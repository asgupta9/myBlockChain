const fs = require('fs');
const web3 = require('./web3Client.js');
const code = fs.readFileSync('myContract.sol').toString();
const solc = require('solc');	// The  solidity compiler
const compiledCode = solc.compile(code);
const abiDefinition = JSON.parse(compiledCode.contracts[':myContract'].interface);
const myContract = web3.eth.contract(abiDefinition);
const byteCode = compiledCode.contracts[':myContract'].bytecode;
const deployedMyContract = myContract.new({ data: byteCode, from: web3.eth.accounts[0], gas: 4700000 });

module.exports = deployedMyContract;

// for deploying on the real testing ropsten ethereum

// const Web3 = require('web3');
// const fs = require('fs');
// const solc = require('solc');
// let web3;
// if (typeof web3 !== 'undefined') {
//     web3 = new Web3(web3.currentProvider);
// } else {
//     web3 = new Web3(new Web3.providers.HttpProvider('https://ropsten.infura.io/v3/058b1ce72d7b401d803a97c373ab425f'));
// }
// const source = fs.readFileSync('myContract.sol', 'utf8');
// const compile = solc.compile(source, 1);
// const contractCompile = Object.values(compile.contracts)[0];

// // my metamask public address
// const deployAddr = '0x37e7AbD26D85fc9Daf7E18Eb66A93eB076c2ffAf';

// const contractByteCode = '0x' + contractCompile.bytecode;
// const contractAbi = JSON.parse(contractCompile.interface);
// const gasEstimate = web3.eth.estimateGas({data: contractByteCode});
// const gasPrice = '20000000000';
// const myContract = new web3.eth.Contract(contractAbi, {
//     from: deployAddr,
//     gas: '15000000',
//     gasPrice: gasPrice,
// });
// const initialSupply = 10000000000;
// const tokenName = 'LLT';
// const tokenSymbol = 'LLT';

// myContract.deploy({
//     data: contractByteCode,
//     arguments: [initialSupply, tokenName, tokenSymbol]
// }).send({
//     from: deployAddr,
//     gas: '15000000',
//     gasPrice: gasPrice
// }, function (error) {
//     console.log(error);
// })
// .on('transactionHash', function (transactionHash) {console.log(transactionHash)})
// .on('receipt', function (receipt) {
//     console.log(receipt.contractAddress) // contains the new contract address
// }).on('confirmation', function (confirmationNumber, receipt) {
// }).then(function (newContractInstance) {
//     console.log(newContractInstance.options.address) // instance with the new contract address
// }).catch(err => {
//     console.log("Error: failed to deploy, detail:", err)
// });