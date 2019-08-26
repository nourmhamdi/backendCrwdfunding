pragma solidity ^0.5.3;
import "./StandardToken.sol";
import"./owned.sol";
 
/**
 * @title Mintable token
 * @dev Simple ERC20 Token example, with mintable token creation
 * @dev Issue: * https://github.com/OpenZeppelin/zeppelin-solidity/issues/120
 * Based on code by TokenMarketNet: https://github.com/TokenMarketNet/ico/blob/master/contracts/MintableToken.sol
 */
 
contract MintableToken is StandardToken, Owned{
    /* to mint is the fact of creating tokens in ouw case, it allows to increment the balance of the owner andi his total supply  */
  event Mint(address indexed to, uint256 amount);
  
  event MintFinished();
 
  bool public mintingFinished = false;
 
  address public saleAgent;
 
  function setSaleAgent(address newSaleAgnet) public {
    require(msg.sender == saleAgent || msg.sender == owner);
    saleAgent = newSaleAgnet;
  }
 
  function mint(address _to, uint256 _amount) public returns (bool) {
    require(msg.sender == saleAgent && !mintingFinished);
    totalSupply = totalSupply.add(_amount);
    balances[_to] = balances[_to].add(_amount);
    emit Mint(_to, _amount);
    return true;
  }
 
  /**
   * @dev Function to stop minting new tokens.
   * @return True if the operation was successful.
   */
  function finishMinting() public returns (bool) {
    require((msg.sender == saleAgent || msg.sender == owner) && !mintingFinished);
    mintingFinished = true;
    emit MintFinished();
    return true;
  }
 
  
}

