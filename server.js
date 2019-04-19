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

app.get('/read', function(req, res){
  const x = contractInstance.readX.call({ from: web3.eth.accounts[0] }).toString();
  console.log(x);
	res.send({ value : x}); 
});
app.get('/write/:values', function(req, res){
 
  var valueToWrite = req.params.values;
  console.log(valueToWrite);

  contractInstance.writeX(valueToWrite, {from: web3.eth.accounts[0] }, function(){
    res.send({ status: 'success'}); 
  })

});

app.listen(3000, function () {
  console.log('listening on 3000 : ')
});

