const express = require('express');
const contractInstance = require('./deployedContract.js');
const web3 = require('./web3Client.js');
const app = express();
const bodyParser = require('body-parser');
const path = require('path');


app.use(express.static(path.join(__dirname, 'public')));
app.use(bodyParser.json());

app.get('/', function(req, res){
  res.sendFile(path.join(__dirname + 'public/index.html'));
});

app.get('/read/:acc', function(req, res){
  
  var account = req.params.acc;
  console.log("read param " + account);
  const x = contractInstance.readX.call({ from: web3.eth.accounts[account] }).toString();
	res.send({ value : x}); 
});

app.get('/write/:values/:acc', function(req, res){
 
  var account = req.params.acc;
  var valueToWrite = req.params.values;
  console.log("write param " + valueToWrite + account);
  contractInstance.writeX(valueToWrite, {from: web3.eth.accounts[account] }, function(){
    res.send({ status: 'success'}); 
  })

});

app.listen(3000, function () {
  console.log('listening on 3000 : ')
});

