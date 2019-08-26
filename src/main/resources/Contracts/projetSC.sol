pragma solidity ^0.5.3;
import "./clientSC.sol";
import "./sharedLib.sol";
import"./owned.sol";
import "./crowdFactory.sol";
import "./Reward.sol";
contract projetSC is Owned {
    
     using sharedLib for sharedLib.Projet;
          sharedLib.Projet public Projet; 

     using sharedLib for sharedLib.ProjectStatus;

     uint PID ;
     address public clientSC; 
     address public CrowdFactory;
     
     mapping (uint =>address ) public contributors;
     mapping (uint => sharedLib.Contribution)  contributions;
     uint contributionNumber;
     uint contributorNumber;
     bool montantAtteint ;
             //we need to  check WHETHER THIS IS THE FIRST TIME THAT APERSON IS CONTRIBUTING TO THIS CAMPAIGN

     uint rewardNumber; // nbre de reward du projet 
     bool rewarded ; //if the project have rewards
     mapping (uint=> address) projectRewards;
     uint addedReward; 
     bool relance ;

event CompagenExtended(uint dateDeFin, uint newClosingTime);

    event newContribution(uint indexed time, uint montant, address contributor);
    event newRewardAdded(string rewardTitle, uint rewardID);
    event rewardConsummed (string rewardTitle);
    event projectInitiated(address projet,address porteur );
    
    //----------------------modifier  ----------------------------        

       //verifier si le projet à depasser le deadline 
    modifier Expired() {
        require(now >= Projet.dateDeFin);
        _;
    }
    modifier Active(){
        require (Projet.stat==sharedLib.ProjectStatus.Active);
        _;
    }
    //   Active,
    //   Expired,
    //   Closed,
    //   Relanced, 
    //   Failed,
    //   Succeeded
    //----------------------constructeur  ----------------------------  
    
   constructor (  string memory _title, uint _montantACollect ,uint _dateDeFin , uint _rewardNumber ) public payable {
       
       Projet =sharedLib.Projet({
         
             porteur :msg.sender ,
             title : _title,
             montantACollect : _montantACollect ,
             montantCollect:0,
             dateDeDebut: now,
             dateDeFin :_dateDeFin,
             contractAddress:address(this),
             stat:sharedLib.ProjectStatus.Waiting 
  
       });
        rewardNumber =_rewardNumber;
        if(rewardNumber==0)
            {rewarded=false; }
        else
            {rewarded =true;}
         montantAtteint = false;
         relance =false;
        clientSC = msg.sender; 
        // CrowdFactory =msg.sender;
     
   }
    //----------------------Getters And Setters----------------------------
    function getProject() public view returns (uint,address, string memory, uint , uint,uint, uint, address, sharedLib.ProjectStatus, uint)
    {
        return (PID,
        Projet.porteur,
        Projet.title,
        Projet.montantACollect,
        Projet.montantCollect,
        Projet.dateDeDebut,
        Projet.dateDeFin,
        Projet.contractAddress,
        Projet.stat,
        rewardNumber);
    }
    function getProjectID() public view returns(uint){ return PID;}
    function getProjectPorteur() public view returns(address){ return Projet.porteur;}
    function getProjectTitle() public view returns(string memory){ return Projet.title;}
    function getProjectMontantACollect() public view returns(uint){ return Projet.montantACollect;}
    function getProjectMontantCollect() public view returns(uint){ return Projet.montantCollect;}
    function getProjectDateDebut() public view returns(uint){ return   Projet.dateDeDebut;}
    function getProjectDateFin() public view returns(uint){ return Projet.dateDeFin;}    
    function getProjectState() public view returns(sharedLib.ProjectStatus){ return Projet.stat;}
    function getProjectContractAddress() public view returns(address){ return Projet.contractAddress;}
    function getProjectRewardNumber() public view returns(uint){ return rewardNumber;}
function getIfRewarded() public view returns (bool){return rewarded; }
    function setProjectID(uint _pID) public {  PID = _pID;}
    function setProjectPorteur(address _porteur) public {  Projet.porteur =_porteur;}
    function setProjectTitle(string memory _title) public { Projet.title= _title;}
    function setProjectMontantACollect(uint _montantACollect ) public{ Projet.montantACollect= _montantACollect;}
    function setProjectMontantCollect(uint _montantCollect) public{Projet.montantCollect= _montantCollect;}
    function setProjectDateDebut(uint _dateDeDebut ) public{Projet.dateDeDebut= _dateDeDebut;}
    function setProjectDateFin(uint _dateDeFin) public {Projet.dateDeFin= _dateDeFin;}    
    function setProjectState(sharedLib.ProjectStatus _stat) public {  Projet.stat=_stat;}
    function setProjectContractAddress(address _contractAddress) public{Projet.contractAddress = _contractAddress;}
    function setProjectRewardNumber(uint _rewardNumber) public { rewardNumber =_rewardNumber;}
    

function addReward(uint256 _totalSupply ,uint256 _initialAmount, string memory _name,string memory _symbol,uint _nbreOfItem)public 
     returns (RewardToken newReward )
        {
         require(rewarded && addedReward <=rewardNumber);
                newReward= new RewardToken  ( _totalSupply,_initialAmount,_name,_symbol,_nbreOfItem);
                addedReward++;
                newReward.setRewardID(addedReward);
                projectRewards[addedReward]= address (newReward);
                emit newRewardAdded( _name,  newReward.getRewardID());
                return (newReward) ;
        } 

    

    //------------------------------------------------
    //  function fund() public Active payable {
    //     contributions.push(
    //         sharedLib.Contribution({
    //             ammount : msg.value,
    //             // tokenValue: ;
    //             // chosenReward;       
    //             projet:this(address),
    //             contributeur:msg.sender ,
    //             porteur:Projet.porteur
            
             
    //             })
    //         );
    //         contributionNumber++;
    //         contributorNumber++;
    //         Projet.montantCollect+= msg.value;
    //         contributors[contributorNumber]=msg.sender;
    //         contributions[contributionNumber]=msg.value;
    //       emit newContribution( now,msg.value , msg.sender);

    // }
 
    //--------------------------------------------------

   
//----------------------Ajouter un projet -----------------------------------------
 /*un client ayant un compte peut à tout moment lancer une compagne à partir de son smartcontract CLient 
 une fois sa compagen est accepté par le crwodfactory son projet sera ajouter au mapping du projet dans le CrowdFactory 
 ainsi que son ProjectStatus*/
    // function appNewProject (address adr) 
    // public
    // returns(bool)
    // {
    //  projetSC Project = projetSC(adr);
    //  if (Project.getProjectState () ==sharedLib.ProjectStatus.Waiting)
    //  {
    //      if(Project.getProjectDateFin() <= Project.getProjectDateDebut())
    //       {  Project.setProjectState(sharedLib.ProjectStatus.Refused);
    //           return false;
         
    //       }else 
           
    //       {
    //         Project.setProjectState(sharedLib.ProjectStatus.Active);
    //         Projects.push(Project.getProjectContractAddress());        
    //         nbrProjetTotal =Projects.length;
    //         projectsinfo[nbrProjetTotal]=Project;
            
    //         return true;

    //      } 
    //   }
  
    // } 


//     modifier butatteint() {
//         require(this.balence > = goal , "Le porteur du projet ne peut pas participer ");
//         _;
// }
//     modifier notended() {
// //         require(now <= deadline, "La dur�e du compagne est expir� ");
//       _;
// }
    //   function amountContributed(address _contributor) public view returns (uint) {
    //     return contributions[_contributor];
    //     }



  // event LogRefund(address indexed contributor, address indexed project, uint indexed amount);
  //event LogPayout(address indexed beneficiary, uint indexed payout);
  //event GoalReached(address recipient, uint totalAmountRaised);
 // event FundTransfer(address backer, uint amount, bool isContribution);
 //event Contributed(uint _Idprojet, address _contributeurr, uint _montant);

/*fonction contribuer*/
// fonction qui retourne le nombre des contibuteurs 







// statut du projet

// modifier projectstat{
//     if (now >= p.dateDeDebut && now< p.dateDeFin){
//         p.stat = s.Active ;
//     }
//     if (!p.montantAtteint){
//         p.stat=s.Closed;
//     }
//     if(now >= p.dateDeFin ) {
//         if (!p.montantAtteint){
//             p.stat=s.Closed;
//         }
//         else if (!p.relance && p.montantAtteint){
//             p.stat=s.Relanced;
//         }
//         else{
//             p.stat=s.Expired;
//         }
//     }
// _;
// }

 function extendTime(uint256 newClosingTime) internal onlyOwner {
        require( Projet.stat== sharedLib.ProjectStatus.Expired);
        // solhint-disable-next-line max-line-length
        require(newClosingTime > Projet.dateDeFin, "TimedCrowdsale: new closing time is before current closing time");

        emit CompagenExtended(Projet.dateDeFin, newClosingTime);
        setProjectDateFin (newClosingTime);
    }
 function removeContract()
        public
      onlyOwner()
        {
            selfdestruct(msg.sender);
            // creator gets all money that hasn't be claimed
        }
// a closed compagne could be relanced 
 function finishCompaign () public{
        if (now >= Projet.dateDeFin) {
          setProjectState(sharedLib.ProjectStatus.Closed); 
        }
}

}




