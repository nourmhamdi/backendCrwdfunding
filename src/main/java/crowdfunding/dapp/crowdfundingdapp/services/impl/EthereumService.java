package crowdfunding.dapp.crowdfundingdapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
@Service
public class EthereumService {
    @Autowired
    private Web3j web3j;

    public String getWeb3Version () {

        return  this.web3j.netVersion().getJsonrpc().toString();
    }
}
