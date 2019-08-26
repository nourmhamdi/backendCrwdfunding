pragma solidity ^0.5.3 ;
import "./MintableToken.sol";
import "./sharedLib.sol";

pragma experimental ABIEncoderV2;
contract RewardToken is MintableToken{
    uint rewardID;
    string public name;
   /* the symbol  of a token descripe the type of the token , either it's a Stake in project, A Deeds of ownership, A Token of Value,
    Tokens of Membership  or Redeemable tokens (organisation and charity compains  case  )*/
    string public  symbol;
    uint32 public  decimals = 18;
    bool taken;
    uint rewardValue;
    uint nbreOfItem;
    sharedLib.RewardItem[] public rewItems;
    mapping (uint=> sharedLib.RewardItem) RewardItems;
    uint rewarditemslength ;
 
    constructor(uint256 _totalSupply ,uint256 _initialAmount, string memory _name,string memory _symbol,uint _nbreOfItem)public{
        totalSupply = _totalSupply;  // Update total supply
        balances[msg.sender] += _initialAmount;               // Give the creator all initial tokens
        name= _name;
        symbol=_symbol;
        nbreOfItem= _nbreOfItem;
        taken = false; 

    }
    
    
 function SetTotalSupply(uint _totalSupply) public  {totalSupply = _totalSupply;}
    function GetTotalsupply() public view returns (uint) {return totalSupply;}
    function addRewardItem ( string memory _itemTitle, uint  _itemValue, string memory _itemDescription) public{
        
        // require (rewarditemslength <nbreOfItem);
        sharedLib.RewardItem memory i;
    //the constractor allow a project owner to create his personal token    ! not sure maybe the mint function will do it for u ==> ah la the mint function will genereate tokens an not create the token name 
        i = sharedLib.RewardItem({
                itemID:rewarditemslength++,
                itemTitle:_itemTitle,
                itemValue :_itemValue, 
                itemDescription:_itemDescription
            });
            rewardValue+=_itemValue; 
            rewarditemslength++;
            // RewardItems[rewarditemslength]=i;
            rewItems.push(i);
            }
    function getRewarditem (uint id )  public  view returns(uint ,string memory, uint , string memory )  {
         sharedLib.RewardItem memory i;
         i=rewItems[id];
         return(i.itemID,i.itemTitle,i.itemValue,i.itemDescription);
         
            }
    function getRewarditems ()public view  returns(sharedLib.RewardItem[] memory)  
        
         { return rewItems;}
    
    function getRewardValue ()public view returns(uint){return rewardValue;}
    function setRewardValue (uint _rewval)public  {rewardValue = _rewval;}

    
    //     function getRewarditems ()public view  returns(mapping)  {
    //     return RewardItems;
    // }
    // function getReward () public view returns() {
        
    // }
    
    
    function setRewardID (uint rewID) public {
        rewardID =rewID;
    }
    
    function getRewardID() public view returns (uint){return rewardID;}
        
   
}
