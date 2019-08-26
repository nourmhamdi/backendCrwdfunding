pragma solidity ^0.5.3;
import "./projetSC.sol";
import "./sharedLib.sol";
import "./owned.sol";
import "./crowdFactory.sol";
 import"./Reward.sol";
contract ClientSC is Owned {
    CrowdFactory crowdfactory ;

      using sharedLib for sharedLib.Client;
            sharedLib.Client Client; 
        uint projectsNB;
        uint contributionsNB;
        uint rewardNB;
        
        mapping (uint=> projetSC) myProjects;
        mapping (uint => sharedLib.Contribution)  myContributions; 
        mapping (uint=> RewardToken) myRewards;

        
//-----------------------------events--------------------------

     event newProjectRequest (address add,  string  title);

      using sharedLib for sharedLib.Contribution;
    // using sharedLib for sharedLib.Reward; 
  
      using sharedLib for sharedLib.Projet;
        
      address public Crowdfactory;
        
        
        

        event IContributed (address Projet, uint ammount);
        

//----------------------------- modifier-----------------------
//   modifier loggedIn();

//-----------------------------constructor---------------------
        
        constructor (address sender , uint _userId,string memory _mail ,string memory _password ) public payable {
          //initialiser la structure client
          // ClientSC.Client.userId
      crowdfactory= CrowdFactory(msg.sender);
            Client = sharedLib.Client({
                userId:_userId,
                mail :_mail, 
                password:_password, 
                contractAddress: address (this), 
                owner:sender 
                
            });
            projectsNB=0;
            contributionsNB=0;
          
            

        }
        
  function getprojectsNB() public view returns ( uint){
            return (projectsNB);
        }
        
        function getcontributionsNB() public view returns ( uint){
            return (contributionsNB);
        }
        function getCrowdfactory() public view returns ( address){
            return (Crowdfactory);
        }
        function getMail() public view returns (string memory){
            return (Client.mail);
        }
           function getUserId() public view returns (uint ){
            return (Client.userId);
        }
        function getPassword() public view returns (string memory){
            return (Client.password);
        }
        
        function getcontractAddress() public view returns(address){
            return(Client.contractAddress);
        }
        function getowner() public view returns(address){
            return(Client.owner);
        }

    
//-----------------------------getters and setters--------------------------
        function getMyInfo () public  view returns (uint, string memory  , string memory, address, address,uint,uint) {
            return(Client.userId,
                Client.mail,
                Client.password,
                Client.contractAddress,
                Client.owner,
                projectsNB,
                contributionsNB);
            
        }
        
        
//-------------------------add new project -------------------
        // demande d'ajout de projet 
        function addNewProject ( string memory _title, uint _montantACollect ,uint _dateDeFin , uint _rewardNumber)   
        public
        returns (projetSC newProjet )
        {
         require(_montantACollect >=0);
                newProjet = new projetSC  ( _title,_montantACollect,_dateDeFin, _rewardNumber);
                projectsNB++;
                myProjects[projectsNB]= newProjet;
                emit newProjectRequest (newProjet.getProjectContractAddress(),  _title);
                crowdfactory.setProjects(address(newProjet));
                return (newProjet) ;
        } 
        
// @l'address du projet
// @l'address du reward choisie 
// @valeur de contribution 

/*fonction contribuer prend comme parametre reward choisi montant a verser verifie que le montant est superieur
ou egal � la valeur du reward choisi que le contributeur a le montant */
//function contribute
function contribute(address  projectADD, address ChosenReward  )public  payable {
        require (     now > projetSC(projectADD).getProjectDateFin())  ;
        
        require (msg.value >0);
        require (msg.value>= RewardToken(ChosenReward).getRewardValue ());
        contributionsNB ++;
  myContributions[contributionsNB]=
            sharedLib.Contribution({
                ammount :msg.value,
                // tokenValue: ;
                // chosenReward;       
                projet:projectADD,
                contributeur: getcontractAddress(),
                porteur:projetSC(projectADD).getProjectPorteur()
                
            });
        
        projetSC(projectADD).setProjectMontantCollect(msg.value);        
        emit IContributed(projectADD, msg.value);

        if(projetSC(projectADD). getIfRewarded()) {
            uint i = RewardToken(ChosenReward).GetTotalsupply(); 
            RewardToken( ChosenReward).SetTotalSupply(i-1 );
            rewardNB++;
            
            myRewards[rewardNB]= RewardToken( ChosenReward);
        }
            
            
            if (projetSC(projectADD).getProjectMontantCollect()>= projetSC(projectADD).getProjectMontantACollect())
            { projetSC(projectADD).setProjectState(sharedLib.ProjectStatus.Succeeded); }
 // i need to decrease the balance of the sender send it to the escrow and increase the balance of the project 
 //
 
}



        // function getMyRewardsByContributionId(uint _id )public view returns(string memory, uint){
        //     sharedLib.Reward memory r = myRewards[_id];
        //     return(r.rewardTitle, r.rewardValue );
            
        // }
        
        
        // function getMyContributionById(uint _id) public  view returns(uint  ,string memory  ,uint, address, address){
            
        //     sharedLib.Contribution memory c= myContributions[_id];
        //     string memory rewardTitle ;
        //     uint  rewardValue;
        //     // (rewardTitle, rewardValue) = getMyRewardsByContributionId( _id );
        //     return(c.ammount,rewardTitle, rewardValue,c.porteur,c.projet );
        //     // , c.tokenValue
        // }
        


//   function addNewProject ( uint _pID,   string  memory _title, uint _montantACollect ,uint _montantCollect, uint  _dateDeFin)

//   public
//   {
//       require (isRegistred(msg.sender));
//      // require(_dateDeFin > now);
//     //  require(login(usersinfo[msg.sender]));
//                 address add = usersinfo[msg.sender].contractAddress;
//                 projetSC newProjet = new projetSC  (add);
//                 projectsinfo[add].porteur= add;
//                 projectsinfo[add].pID= _pID;
//                 projectsinfo[add].title=_title;
//                 projectsinfo[add].montantACollect= _montantACollect;
//                 projectsinfo[add].montantCollect=0;
//                 projectsinfo[add].dateDeDebut=now;
//                 projectsinfo[add].dateDeFin=_dateDeFin;
//                 projectsinfo[add].stat=sharedLib.ProjectStatus.Active;
//                 projectsinfo[add].contractAddress=  address (newProjet);
//                 Projects.push( address (newProjet));
//                 emit registred(address (newProjet),msg.sender, _pID);
//   } 
 
        //  function getMyProjectById(uint _id)public returns(uint ,string memory ,uint,uint , uint  , uint  ,address , sharedLib.ProjectStatus ,string memory, uint)
        //  {
        //     sharedLib.Projet memory p= myProjects (_id);
        //     string memory rewardTitle ;
        //     uint  rewardValue;
        //     (rewardTitle, rewardValue) = getMyRewardsByContributionId( _id );
        //     return(
        //         p.pID,
        //         p.title, 
        //         p.montantACollect, 
        //         p.montantCollect,
        //         p.dateDeDebut, 
        //         p.dateDeFin, 
        //         p.contractAddress, 
        //         p.stat,
        //         rewardTitle, 
        //         rewardValue
                
        //         );
        //  }
 
   
      //voter 
      //commenter 
      // suprimer son compte 
      //suprimer projet 
      // arreter compage 
      //modifier projet 
      //modifier profil 


}
