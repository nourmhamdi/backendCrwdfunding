package crowdfunding.dapp.crowdfundingdapp.services.interfaces;

import crowdfunding.dapp.crowdfundingdapp.auth.model.User;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

public interface CrowdFactoryService {
    TransactionReceipt Registration(User user) throws Exception;
}
