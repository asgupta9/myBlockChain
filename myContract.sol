pragma solidity ^0.4.11;

contract myContract{
  

    uint256 x;
    
    function myContract() public{
        x = 0;
    }
    function readX() public returns (uint256){
        return x;
    }
    function writeX() public{
        x += 1;
    }   

}