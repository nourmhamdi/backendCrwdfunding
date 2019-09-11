//package crowdfunding.dapp.crowdfundingdapp.controllers;
//
//import crowdfunding.dapp.crowdfundingdapp.models.User;
//import crowdfunding.dapp.crowdfundingdapp.services.impl.CrowdFactoryServiceImpl;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.web3j.protocol.core.methods.response.TransactionReceipt;
//
//public class CrowdFactoryController {
//CrowdFactoryServiceImpl crowdFactoryService;
//    @PostMapping(value = "api/registration")
//    public ResponseEntity<?> generate_wallet(  @RequestBody User user) throws Exception {
//        return new ResponseEntity<TransactionReceipt>(crowdFactoryService.Registration( user), HttpStatus.OK);
//    }
//}
