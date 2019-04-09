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
