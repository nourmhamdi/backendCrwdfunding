//package crowdfunding.dapp.crowdfundingdapp.services.interfaces;
//
//
//import crowdfunding.dapp.crowdfundingdapp.models.Block;
//import crowdfunding.dapp.crowdfundingdapp.models.DataStored;
//import org.json.JSONException;
//import org.web3j.crypto.CipherException;
//import org.web3j.crypto.Credentials;
//import org.web3j.protocol.core.methods.response.Transaction;
//import org.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.web3j.tuples.generated.Tuple7;
//
//import java.io.IOException;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//
//public interface Etat {
//
//    String add_file(String file_path) throws IOException;
//    String read_data(String hash_file) throws IOException, JSONException;
////    TransactionReceipt send_info_smartcontract(DataStored sent) throws Exception;
////    Tuple7<BigInteger, String, String, String, String, String, String> get_data_from_smartcontract(int id, String addr, String pass, String type) throws Exception;
////    List Get_idtable(String _access, String addr, String pass, String type) throws Exception ;
////    ArrayList<Tuple7<BigInteger, String, String, String, String, String, String>> get_listadded(String addr, String pass, String type, String _access) throws Exception;
//    ArrayList<String> listPathWallet(String type) throws IOException;
//    Credentials getCreds(String address, String pass, String type) throws IOException, CipherException;
////    List<String> getallusers() throws Exception;
//    ArrayList<Block> listBlock() throws IOException;
////    ArrayList<Transaction> listTransaction() throws IOException;
//}
