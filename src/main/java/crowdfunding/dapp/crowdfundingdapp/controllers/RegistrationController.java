//package crowdfunding.dapp.crowdfundingdapp.controllers;
//
//import crowdfunding.dapp.crowdfundingdapp.models.User;
//import crowdfunding.dapp.crowdfundingdapp.services.impl.EthereumService;
//import crowdfunding.dapp.crowdfundingdapp.services.impl.RegistrationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin("*")
//@RestController
//public class RegistrationController {
//    @Autowired
//    RegistrationService registrationService;
//    @Autowired
//    EthereumService ethereumService;
//
//    @CrossOrigin("*")
//    @PostMapping("/registration" )
//    public  void signUp ( @RequestBody User user){
//        System.out.print(this.registrationService.signUp(user));
//        System.out.print("done");
//    }
//    @GetMapping("/hi")
//    public String sayHello () {
//
//        return  this.ethereumService.getWeb3Version();
//    }
//
//}
