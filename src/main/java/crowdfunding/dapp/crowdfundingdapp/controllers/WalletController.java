//package crowdfunding.dapp.crowdfundingdapp.controllers;
//
//import crowdfunding.dapp.crowdfundingdapp.services.impl.WalletService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.math.BigInteger;
//
//@RestController
//@CrossOrigin("*")
//public class WalletController {
//
//    @Autowired
//    WalletService walletService;
//
//    @CrossOrigin("*")
//    @GetMapping("/getWallet")
//    String getcreateWallet() throws Exception {
//        String s = WalletService.walletCreation();
//        return s;
//    }
//
//    @GetMapping("/getWalletAddress")
//    String getWalletAddress() throws Exception {
//        String s = WalletService.walletAddress();
//        return s;
//    }
//
//    @GetMapping("/getWalletBalance")
//    BigInteger getBalance() throws Exception {
//        BigInteger s = WalletService.getBalanceTransaction();
//        return s;
//    }
//
//    @GetMapping("/transactionsend")
//    String transactionSend() throws Exception {
//        String s = WalletService.TransactionSend();
//        return s;
//    }
//
//}
