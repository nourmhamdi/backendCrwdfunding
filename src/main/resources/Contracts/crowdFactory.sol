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
    event loggedin(address ,uint);

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
   
//----------------------Login-----------------------------------------
/*Verifie si le client existe en verifiant si son address ethereum existe  */ 
    function login(address sender,string memory _mail, string memory _password) 
    public
    returns(bool){
         require(isRegistred(sender));
          if(keccak256(abi.encodePacked(userContract[sender].getMail())) == keccak256(abi.encodePacked(_mail))&&
          keccak256(abi.encodePacked(userContract[sender].getPassword())) == keccak256(abi.encodePacked(_password))){
              return true;

              emit loggedin(sender,userContract[sender].getUserId());
          }else{
              return false;
          }
    }
        

//----------------------Get one user by address-----------------------------------------
 function getUser(address _userAddress)
    public
    view
    returns ( uint  ,string memory ,string memory , address , address){
        return (userContract[_userAddress].getUserId() ,userContract[_userAddress].getMail() ,userContract[_userAddress].getPassword() ,userContract[_userAddress].getowner() ,userContract[_userAddress].getcontractAddress());
    }

// //----------------------Get all users addresses -------------------------------------------------
function getAllUsersAdd()
    public
    view
    returns (address [] memory ){
        return users;
    }
// //----------------------Get one user address by id -------------------------------------------------
    
function getoneUsersAdd(uint id)
    public
    view
    returns (address ){
        return users[id];
    }
// //----------------------Get one user by id -------------------------------------------------
function getOneUserbyId(uint id)
    public
    payable
    returns ( uint, string memory  , string memory, address, address,uint,uint ){
        return (userContract[users[id]].getMyInfo());
    }
    function setProjects(address newprojt)public {
        Projects.push(newprojt);
    nbrProjetTotal++;}
    function getProjectNumber() public view returns (uint) {return  nbrProjetTotal;}
    
    //----------------------get projet -----------------------------------------
// /* crowdfactory permet au utilisateur meme non inscrit de consulter des inforamtions sur les projet*/
//  function getProject(address adr) public view returns(uint, address){
//          projetSC Project = projetSC(adr);
//          return (Project.getProjectDateFin (), Project.getProjectContractAddress());
//     }
   
//-----------------------treatProjectRequest--------------------------------------
function treatProjectRequest () public {
    for (uint i =0; i<nbrProjetTotal; i++){
     
      projetSC  projtToTreat =projetSC(Projects[i]); 
      if (projtToTreat. getProjectState()== sharedLib.ProjectStatus.Waiting ){
      projtToTreat.setProjectState(sharedLib.ProjectStatus.Active);}
    }
}
}
