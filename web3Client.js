const Web3 = require('web3')
const web3 = new Web3(new Web3.providers.HttpProvider("https://ropsten.etherscan.io/tx/0x8a14d7718cba820f3044c09b286004723b3fc38b4b88ddfb8c4b97b418246c84"));

module.exports = web3; 
