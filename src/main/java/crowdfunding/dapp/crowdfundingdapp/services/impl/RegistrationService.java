package crowdfunding.dapp.crowdfundingdapp.services.impl;


import crowdfunding.dapp.crowdfundingdapp.auth.model.User;
import crowdfunding.dapp.crowdfundingdapp.services.wrappers.CrowdFactory;
import crowdfunding.dapp.crowdfundingdapp.services.wrappers.WrapperContractFactory;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.request.Transaction;

@Service
public class RegistrationService {

    WrapperContractFactory wrapperContractFactory;


    CrowdFactory crowdFactory;

    public RegistrationService(){
        this.wrapperContractFactory = new WrapperContractFactory();
        this.crowdFactory = this.wrapperContractFactory.getCrowdfactoryWrapper();
        System.out.print(crowdFactory);
    }

    public String signUp(User user){
        try
        {
            System.out.print("hhhhhhhhhhhwhat");
            this.crowdFactory.Registration(user.getAddress(),user.getEmail(), user.getPassword()).send();
            System.out.print("hhhhhhhhhhhwhat1");

            return ("registred");
        } catch (Exception e){
            System.out.print("hhhhhhhhhhhwhat2");

            e.printStackTrace();
            return e.getMessage();

        }

    }
}
