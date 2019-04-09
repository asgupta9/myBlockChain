pragma solidity ^0.4.11;

contract myContract{
  
    uint256 x;
    uint256 lock;  
    function myContract() public{
        x = 0;
        lock = 0;
    }
    function readX() public returns (uint256){
        while(lock!=0){}
        return x;
    }
    function writeX() public{
        lock = 1; 
        x += 1;
        lock = 0;
    }   

}