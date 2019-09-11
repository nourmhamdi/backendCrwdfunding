package crowdfunding.dapp.crowdfundingdapp;


import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import java.io.File;

public class WalletManager {

    private Credentials credentials;


    public WalletManager() {
//        "password", "/path/to/walletfile"
        File file = new File("/home/nour/Documents/finalNetwork/users/keystore/UTC--2019-09-06T14-57-14.126911826Z--c3a6bfbd29a2198c817cc4d8cb8a867be801cbc2");
        String password = "123456";
        try {

            this.credentials = WalletUtils.loadCredentials(password, file);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public Credentials getWallet () {

        return this.credentials;
    }
}
