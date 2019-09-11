pragma solidity ^0.5.3;
pragma experimental ABIEncoderV2;
import "./sharedLib.sol";
import "./clientSC.sol";
import "./projetSC.sol";
contract CrowdFactory{



    using sharedLib for sharedLib. ProjectStatus;
    constructor()public{}
    uint nbrProjetTotal;
//----------------------mapping--------------------
     mapping(address => ClientSC) public userContract;  // contient les donn�es des utilisateurs

     mapping (uint=> projetSC)public projectsinfo; // contient les donn�es des projets
//----------------------tableau d'addresse --------------------

    address[] public users; // contient les addresse des utilisateurs (wallet)
    address[] public Projects; // contient les addresses des contracts des projet cr�es
    uint usersNumber ;

//----------------------event   --------------------
    event registred(address contractAddress, address publickey, uint userId ) ;
// event projectAdded(address contractAddress, address porteur, uint pID ) ;
 //   event loggedin(address ,uint);

//----------------------verifier l'existance d'un utilisateur -----------------------------------------
//verifier si l'addresse de l'utilisateur existe
    function isRegistred (address _userAddress)
    internal
    view
    returns(bool){
          for(uint256 i = 0; i < users.length; i++){
                if(users[i] == _userAddress) return true;
                else         return false;

          }
    }

//----------------------Registration-----------------------------------------
/*Pour ajouter un client */
   function Registration (address sender ,  string memory _mail ,string memory _password)
   public
   returns (ClientSC newClient )
       {  require (!isRegistred(sender));
       usersNumber++;
                 newClient = new ClientSC  (sender, usersNumber, _mail , _password);
                 userContract[sender]= newClient;
                 newClient.transferOwnership(sender);
                 users.push(sender);
                 emit registred(address(newClient),sender, usersNumber);
                 return (newClient) ;
   }
   function setProjects(address newprojt)public {
      Projects.push(newprojt);
    nbrProjetTotal++;}


}
