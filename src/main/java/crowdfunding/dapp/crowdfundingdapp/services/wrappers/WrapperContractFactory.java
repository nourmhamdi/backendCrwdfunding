package crowdfunding.dapp.crowdfundingdapp.services.wrappers;

import crowdfunding.dapp.crowdfundingdapp.CrowdfundingdappApplication;
import crowdfunding.dapp.crowdfundingdapp.WalletManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.lang.reflect.Method;
import java.math.BigInteger;

public class WrapperContractFactory {

    private String ContractAddress;
    private WalletManager walletManager;
    @Autowired
    Web3j web3j;

    public WrapperContractFactory() {
        this.walletManager = new WalletManager();
        HttpService httpService = new HttpService("http://localhost:8545");
        //Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        this.web3j = Web3j.build(httpService);
    }

    //Instancier les contrat
    public CrowdFactory getCrowdfactoryWrapper() {
        Credentials credentials = this.walletManager.getWallet();
        return CrowdFactory.load("0xdD22cBa3C45d99DEB3dB29d0bD02F606D889Ad9D"
                , this.web3j, credentials,CrowdFactory.GAS_PRICE, CrowdFactory.GAS_LIMIT);
    }



    /*Constructeur sans argument*/
//    public String deployerContract(String nomClasse) {
//
//        Credentials credentials = this.walletManager.getWallet();
//        try {
//            Class<Contract> typeClass = (Class<Contract>) Class.forName("main.java.crowdfunding.dapp.crowdfundingdapp.services.wrappers." + nomClasse);
//            Method methodDeploy = typeClass.getDeclaredMethod("deploy", Web3j.class, Credentials.class, BigInteger.class, BigInteger.class);
//
//            RemoteCall<Contract> resultat1 = (RemoteCall) methodDeploy.invoke(typeClass, this.web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT);
//
//
//            System.out.print("PRICE:" + Contract.GAS_PRICE);
//            Contract resultat2 = resultat1.send();
//            String address = resultat2.getContractAddress();
//            return address;
//        } catch (Exception e) {
//            System.out.print(e.getStackTrace());
//            System.out.print("ciciciciciic");
//            System.out.print(e.getMessage());
//            return null;
//        }
//    }
    public String deploy(){
        Credentials credentials = this.walletManager.getWallet();
        try {
            CrowdFactory contract = CrowdFactory.deploy(web3j, credentials,CrowdFactory.GAS_PRICE, CrowdFactory.GAS_LIMIT).send();
            ContractAddress= contract.getContractAddress();
             return  contract.getContractAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return ("not deployer");
        }

    }

}
