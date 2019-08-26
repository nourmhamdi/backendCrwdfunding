package crowdfunding.dapp.crowdfundingdapp.WebServices;

import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

public interface CrowdFactoryService {
    TransactionReceipt Registration(BigInteger _userId, String _mail, String _password) throws Exception;
}
