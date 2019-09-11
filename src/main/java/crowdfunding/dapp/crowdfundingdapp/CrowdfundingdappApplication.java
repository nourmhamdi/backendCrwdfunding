package crowdfunding.dapp.crowdfundingdapp;

//import crowdfunding.dapp.crowdfundingdapp.DAO.ClientRepository;

import crowdfunding.dapp.crowdfundingdapp.services.wrappers.WrapperContractFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CrowdfundingdappApplication {
//    private ClientRepository Clientrep;


    @Autowired   //pour faire l'injection des dependances

    public static void main(String[] args) {


        SpringApplication.run(CrowdfundingdappApplication.class, args);

    }

//    @Override
//    public  void run (String... arg0)throws  Exception {
//        DateFormat df= new SimpleDateFormat("dd/mm/yyyy");
//
//        CLient c=new CLient("nour", "mhamdi", "addethe","nour.mhamdi@gmail.com","hhhh",df.parse("12/01/1998"), "tunis", "tunis", (long) 536555, "nour.pdf", "nour.jpg");
//        Clientrep.save( c);
//
//    }

}
