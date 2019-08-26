//package crowdfunding.dapp.crowdfundingdapp.controllers;
//
//import crowdfunding.dapp.crowdfundingdapp.Models.CLient;
//import crowdfunding.dapp.crowdfundingdapp.WebServices.CrowdFactoryServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class CrowdfactoryController {
//    @Autowired
//
//    CrowdFactoryServiceImpl CrowdFactoryserv;
//
//    @RequestMapping(value = "/deploy", method = RequestMethod.POST)
//    public void deploy() throws Exception {
//        CrowdFactoryserv.deploy();
//    }
//
//    @RequestMapping(value = "/load/{contractAddress}", method = RequestMethod.GET)
//    public void load(@PathVariable("contractAddress") String contractAddress) throws Exception {
//        CrowdFactoryserv.load(contractAddress);
//    }
//
//    //    @RequestMapping(value = "/add", method = RequestMethod.PUT)
////    public void adduser(@PathVariable("_userId") BigInteger _userId, @PathVariable("_mail") String _mail, @PathVariable ("_password") String _password) throws Exception {
////        CrowdFactoryserv.Registration( _userId, _mail,_password);
////    }
//    @RequestMapping(value = "/add", method = RequestMethod.PUT)
//    public void adduser(@RequestBody CLient user) throws Exception {
//        Boolean add = CrowdFactoryServiceImpl.add(user);
//
//    }
//
////    @Autowired
////    public CrowdfactoryController(CrowdFactoryService crowdFactoryserv) {
////        CrowdFactoryserv = crowdFactoryserv;
////    }
//}
