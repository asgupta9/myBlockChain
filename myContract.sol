pragma solidity ^0.4.11;

contract myContract{
  
    uint256 x;
    uint256 y;
    uint256[2] flag;
    uint turn;

    function myContract() public{
        x = 0;
        y = 0;
        flag[0] = 0;
        flag[1] = 0;
        turn = 0;
    }
    function set() public returns (uint256){
        flag[0]=0;
        return 1;
    }
    function readX() public returns (uint256){
        flag[0] = 1;
        turn = 1;
        while( flag[1] == 1 && turn == 1){}
        y = x;
        return (y * set());
    }
    function writeX(uint256 arg) public{
        flag[1] = 1;
        turn = 0;

        while( flag[0] == 1 && turn == 0){}
        x = arg;
        flag[1]=0;
    }

}