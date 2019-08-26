pragma solidity ^0.5.3;
library sharedLib{
      
//-------------- Client-------------
   struct Client {
        uint userId; 
        string mail ;
        string password;
        address contractAddress;
        address owner; //addresse de son wallet elle sera utilis� pour verifi� sa signature 
       
   }
//-------------- contribution-------------

    struct Contribution{
          uint ammount ; 
        //   uint tokenValue ;
        //   Reward chosenReward;       
          address projet;
          address contributeur ;
          address porteur; 

      } 

 
//-------------- Projet -------------


    //***********reward 

         struct RewardItem{
            uint itemID; 
            string  itemTitle;
            uint  itemValue; // nbre de token 
            string itemDescription;
         }
      
     //***********etat du projet 

    enum ProjectStatus {
       Waiting ,
       Refused,
       Active,
       Expired,
       Closed,
       Relanced, 
       Failed,
       Succeeded

      }
      //***********projet
    struct Projet {
        // uint pID ;
        address  porteur;
        string title;
        uint montantACollect ;
        uint montantCollect;
        uint  dateDeDebut;
        uint  dateDeFin;
        address contractAddress;
        ProjectStatus stat;
    }
     
}


