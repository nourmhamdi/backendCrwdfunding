//package crowdfunding.dapp.crowdfundingdapp.WebServices;
//
//import contracts.CrowdFactory;
//import crowdfunding.dapp.crowdfundingdapp.Models.CLient;
//import org.springframework.stereotype.Service;
//import org.web3j.crypto.Credentials;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.methods.response.Transaction;
//import org.web3j.protocol.http.HttpService;
//
//import java.math.BigInteger;
//
//import static org.web3j.protocol.Web3j.build;
//
//@Service
////public class CrowdFactoryServiceImpl  implements CrowdFactoryService{
//public class CrowdFactoryServiceImpl {
////    private final Web3j web3j;
////0
////    private String contractAddress;
//
//    //    public CrowdFactoryServiceImpl(Web3j web3j) {
////        this.web3j = web3j;
//    static Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:7545"));
//
//    //    }
//    Credentials credentials = Credentials.create("2afdcbf17122b576a8d86aad96a38058965c13b6ae4468b7ada2b1eaca2a574b");
//
//    public static CrowdFactory load(String contractAddress) throws Exception {
//        Web3j web3j = build(new HttpService("http://127.0.0.1:7545"));
//        Credentials credentials = Credentials.create("2afdcbf17122b576a8d86aad96a38058965c13b6ae4468b7ada2b1eaca2a574b");
//        CrowdFactory crowdFact = CrowdFactory.load(
//                contractAddress,
//                web3j,
//                credentials,
//                new BigInteger("3"),
//                new BigInteger("50")
//        );
//        pendingTransactions();
//        System.out.println("loaded contract");
//        System.out.println("contract validity: " + crowdFact.isValid());
//        return crowdFact;
//    }
//
//    public static void pendingTransactions() {
//        Transaction c;
//        web3j.pendingTransactionFlowable().subscribe(tx -> {
//            System.out.println("block hash " + tx.getBlockHash());
//            System.out.println("block number " + tx.getBlockNumber());
//            System.out.println("creats " + tx.getCreates());
//        });
//    }
//
////
////    @Value("${ethereum.contract.crowdFactory.address}")
////    public void setContractAddress(String contractAddress) {
////        if (contractAddress.isEmpty()) {
////            throw new RuntimeException("'ethereum.contract.crowdFactory.address' not informed");
////        }
////        this.contractAddress = contractAddress;
////    }
//
////    public Registration(String contractAddress, BigInteger _userId, String _mail, String _password) throws Exception {
////        CrowdFactory crowdFactory = load(contractAddress);
////        System.out.println("ajout du compte  "+ _userId + "mail" + _mail);
////        TransactionReceipt transactionReceipt = crowdFactory.Registration(_userId, _mail,_password).send();
////        pendingTransactions();
////        System.out.println(transactionReceipt.getStatus());
////        System.out.println("added "+ _userId );
////        System.out.println(transactionReceipt.toString());
////        return null;
////    }
//
//    public static Boolean add(CLient user) throws Exception {
//        CrowdFactory crowdFactory = load("0XCC78A0177988D4D3919017B16C29828788DE95F5\n");
//        crowdFactory.Registration(user.getId(), user.getEmail(), user.getPassword()).send().toString();
//        return true;
//    }
//
//    public CrowdFactory deploy() throws Exception {
//        CrowdFactory crowdFact = CrowdFactory.deploy(
//                web3j,
//                credentials,
//                new BigInteger("3000000"),
//                new BigInteger("5")
//        ).send();
//        pendingTransactions();
//        System.out.println("address " + crowdFact.getContractAddress());
//        return crowdFact;
//    }
////    @Override
////    public TransactionReceipt Registration( BigInteger _userId, String _mail, String _password) throws Exception {
////
//////        CrowdFactory crowdFactory = load("0XCC78A0177988D4D3919017B16C29828788DE95F5\n" );
////////        CrowdFactory crowdFactory = load(contractAddress);
//////        CLient user = new CLient(_userId, _mail,_password) ;
//////        System.out.println( "mail" + user.getEmail());
//////        TransactionReceipt transactionReceipt = crowdFactory.Registration(user.getId(), user.getEmail(),user.getPassword()).send();
//////        pendingTransactions();
//////        System.out.println(transactionReceipt.getStatus());
//////        System.out.println("added ");
////////        System.out.println(transactionReceipt.toString());
////        return null;
////    }
//}
