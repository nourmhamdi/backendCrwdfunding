package crowdfunding.dapp.crowdfundingdapp.services.impl;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class WalletService {
    private static String pathKeyStoreSpring="/home/nour/Documents/finalNetwork/users/keystore/";
    private  static String passwordSpring ="123456";
    private  static String privateKey ="fc41a2c6a2da5e297566df31ef93701391ce945218160adbe1f480c8d12e1826";
    private static  int SLEEP_DURATION = 15000;

    public static String walletCreation() throws Exception {
//        File file = new File("/home/nour/Documents/network/db2/keystore");
        File file = new File("/home/nour/Documents/finalNetwork/users/keystore");
        String password = "";
        String fileName = WalletUtils.generateFullNewWalletFile(password, file);
        System.out.println("File Name------>>> " + fileName);

        return fileName;

    }

    public static String walletAddress() throws Exception {
        File file = new File(pathKeyStoreSpring);
        String password = passwordSpring;
        Credentials credentials = WalletUtils.loadCredentials(password, file);
//           Credentials credentials = Credentials.create(privateKey);

        String s = credentials.getAddress();
        System.out.println("Get Wallet address===  " + credentials.getAddress());
        return s;
    }

    public static BigInteger getBalanceTransaction() throws Exception{
        File file = new File(pathKeyStoreSpring);
        String password = passwordSpring;
//        Credentials credentials = Credentials.create(privateKey);


        Credentials credentials = WalletUtils.loadCredentials(password, file);
        System.out.println("Get Wallet address===  "+credentials.getAddress());
        String address = credentials.getAddress();
        HttpService httpService = new HttpService("http://localhost:8545");
        Web3j web3 = Web3j.build(httpService);
        EthGetBalance balance = web3.ethGetBalance(address, DefaultBlockParameterName.LATEST).sendAsync().get();
        BigInteger s = balance.getBalance();
        System.out.println("---------- "+balance.getBalance());
        return s;
    }

//    public static String TransactionSend()throws Exception{
//        File file = new File(pathKeyStoreSpring);
//        String password = passwordSpring;
////        Credentials credentials = Credentials.create(privateKey);
//
//        Credentials credentials = WalletUtils.loadCredentials(password, file);
//        System.out.println("Get Wallet address===  "+credentials.getAddress());
//        HttpService httpService = new HttpService("http://localhost:8545");
//        Web3j web3 = Web3j.build(httpService);
//        RemoteCall<TransactionReceipt> transactionReceipt = Transfer.sendFunds(web3, credentials,
//                "c3a6bfbd29a2198c817cc4d8cb8a867be801cbc2", BigDecimal.valueOf(300000000), Convert.Unit.ETHER);
//        //address ta3 l wallet
//        Thread.sleep(SLEEP_DURATION);
//
//        TransactionReceipt t = transactionReceipt.send();
//        String s = t.getTransactionHash();
//        System.out.println(t.getTransactionHash());
//        return s;
//    }
}
