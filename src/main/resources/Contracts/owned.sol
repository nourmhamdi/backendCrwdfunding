pragma solidity ^0.5.3;

contract Owned {
     event OwnershipTransferred(address indexed previousOwner, address indexed newOwner);

    address public owner;

    constructor() public {
        owner = msg.sender;
    }

    modifier onlyOwner() {
        assert(msg.sender == owner);
        _;
    }

    function transferOwnership(address newOwner) external onlyOwner {
        if (newOwner != address(0)) {
            emit OwnershipTransferred(owner, newOwner); 
            owner = newOwner;
        }
    }
}






