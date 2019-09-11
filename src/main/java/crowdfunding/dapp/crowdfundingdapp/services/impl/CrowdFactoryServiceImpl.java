//package crowdfunding.dapp.crowdfundingdapp.services.impl;
//
//
//import crowdfunding.dapp.crowdfundingdapp.auth.model.User;
//import crowdfunding.dapp.crowdfundingdapp.services.interfaces.CrowdFactoryService;
//import crowdfunding.dapp.crowdfundingdapp.services.wrappers.CrowdFactory;
//import org.springframework.stereotype.Service;
//import org.web3j.crypto.CipherException;
//import org.web3j.crypto.Credentials;
//import org.web3j.crypto.WalletUtils;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.methods.response.Transaction;
//import org.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.web3j.protocol.http.HttpService;
//import org.web3j.tx.ManagedTransaction;
//
//import java.io.File;
//import java.io.IOException;
//import java.math.BigInteger;
//import java.security.InvalidAlgorithmParameterException;
//import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//import java.util.List;
//
//import static org.web3j.protocol.Web3j.build;
//
//@Service
//public class CrowdFactoryServiceImpl  implements CrowdFactoryService {
//
//    //private key to use the Ganache-cli Blockchain
//    String privateKey = "2afdcbf17122b576a8d86aad96a38058965c13b6ae4468b7ada2b1eaca2a574b";
//    //The path of the Blockchain directory
//    String path_blockchain = "/home/nour/Documents/network/";
//    //The address of Crowdfactory Smartcontract
//    String addressCF = "0x6431fd0c29d024c5b04c7dab157fccd329e62e55";
//
//    Web3j web3j = Web3j.build(new HttpService());
//    //Credentials
//    Credentials credentials = Credentials.create(privateKey);
//
//    @Override
//    public TransactionReceipt Registration(User user) throws Exception {
//        String fileName = null;
//
//        CrowdFactory contract = CrowdFactory.load(addressCF,web3j,credentials,CrowdFactory.GAS_PRICE, CrowdFactory.GAS_LIMIT);
//        fileName = WalletUtils.generateNewWalletFile(user.getPassword(), new File(path_blockchain+"db/keystore/"));
//        return contract.Registration(fileName.substring(37,fileName.length()-5),user.getEmail(),user.getPassword()).send();
//
//    }
//
//
//    //Credentials credentials=getCreds(addr,pass,type);
////
////
////    static Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:7545"));
////
////    //    }
////    Credentials credentials = Credentials.create("2afdcbf17122b576a8d86aad96a38058965c13b6ae4468b7ada2b1eaca2a574b");
////
////    public static CrowdFactory load(String contractAddress) throws Exception {
////        Web3j web3j = build(new HttpService("http://127.0.0.1:7545"));
////        Credentials credentials = Credentials.create("2afdcbf17122b576a8d86aad96a38058965c13b6ae4468b7ada2b1eaca2a574b");
////        CrowdFactory crowdFact = CrowdFactory.load(
////                contractAddress,
////                web3j,
////                credentials,
////                new BigInteger("3"),
////                new BigInteger("50")
////        );
////        pendingTransactions();
////        System.out.println("loaded contract");
////        System.out.println("contract validity: " + crowdFact.isValid());
////        return crowdFact;
////    }
////
////    public static void pendingTransactions() {
////        Transaction c;
////        web3j.pendingTransactionFlowable().subscribe(tx -> {
////            System.out.println("block hash " + tx.getBlockHash());
////            System.out.println("block number " + tx.getBlockNumber());
////            System.out.println("creats " + tx.getCreates());
////        });
////    }
////
//////
//////    @Value("${ethereum.contract.crowdFactory.address}")
//////    public void setContractAddress(String contractAddress) {
//////        if (contractAddress.isEmpty()) {
//////            throw new RuntimeException("'ethereum.contract.crowdFactory.address' not informed");
//////        }
//////        this.contractAddress = contractAddress;
//////    }
////
//////    public Registration(String contractAddress, BigInteger _userId, String _mail, String _password) throws Exception {
//////        CrowdFactory crowdFactory = load(contractAddress);
//////        System.out.println("ajout du compte  "+ _userId + "mail" + _mail);
//////        TransactionReceipt transactionReceipt = crowdFactory.Registration(_userId, _mail,_password).send();
//////        pendingTransactions();
//////        System.out.println(transactionReceipt.getStatus());
//////        System.out.println("added "+ _userId );
//////        System.out.println(transactionReceipt.toString());
//////        return null;
//////    }
////
//////    @Override
//////    public List<String> getallusers() throws Exception {
//////        ENS contract=ENS.load(
//////                ENSSC, web3j,credentials, ManagedTransaction.GAS_PRICE, BigInteger.valueOf(1000000));
//////        contract.getAlluser().send();
//////        return contract.getAllusers().send();
//////    }
//////
//////    public static Boolean add(CLient user) throws Exception {
//////        CrowdFactory crowdFactory = load("0XCC78A0177988D4D3919017B16C29828788DE95F5\n");
//////        crowdFactory.Registration(user.getId(), user.getEmail(), user.getPassword()).send().toString();
//////        return true;
//////    }
//////
//////    public CrowdFactory deploy() throws Exception {
//////        CrowdFactory crowdFact = CrowdFactory.deploy(
//////                web3j,
//////                credentials,
//////                new BigInteger("3000000"),
//////                new BigInteger("5")
//////        ).send();
//////        pendingTransactions();
//////        System.out.println("address " + crowdFact.getContractAddress());
//////        return crowdFact;
//////    }
//////    @Override
//////    public TransactionReceipt Registration( BigInteger _userId, String _mail, String _password) throws Exception {
//////
////////        CrowdFactory crowdFactory = load("0XCC78A0177988D4D3919017B16C29828788DE95F5\n" );
//////////        CrowdFactory crowdFactory = load(contractAddress);
////////        CLient user = new CLient(_userId, _mail,_password) ;
////////        System.out.println( "mail" + user.getEmail());
////////        TransactionReceipt transactionReceipt = crowdFactory.Registration(user.getId(), user.getEmail(),user.getPassword()).send();
////////        pendingTransactions();
////////        System.out.println(transactionReceipt.getStatus());
////////        System.out.println("added ");
//////////        System.out.println(transactionReceipt.toString());
//////        return null;
//////    }
//}
