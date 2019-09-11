//package crowdfunding.dapp.crowdfundingdapp.services.impl;
//
//
//import crowdfunding.dapp.crowdfundingdapp.models.Block;
//import crowdfunding.dapp.crowdfundingdapp.models.DataStored;
//import crowdfunding.dapp.crowdfundingdapp.services.interfaces.Etat;
//import crowdfunding.dapp.crowdfundingdapp.services.wrappers.CrowdFactory;
//import io.ipfs.api.IPFS;
//import io.ipfs.api.MerkleNode;
//import io.ipfs.api.NamedStreamable;
//import io.ipfs.multihash.Multihash;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import org.web3j.crypto.CipherException;
//import org.web3j.crypto.Credentials;
//import org.web3j.crypto.WalletUtils;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.DefaultBlockParameter;
//import org.web3j.protocol.core.methods.response.Transaction;
//import org.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.web3j.protocol.http.HttpService;
//import org.web3j.tuples.generated.Tuple7;
//import org.web3j.tx.ManagedTransaction;
//
//import java.io.File;
//import java.io.IOException;
//import java.math.BigInteger;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.List;
//
//public class EtatImpl implements Etat {
//
//    //private key to use the Ganache-cli Blockchain
//    String privateKey = "2afdcbf17122b576a8d86aad96a38058965c13b6ae4468b7ada2b1eaca2a574b";
//    //The path of the Blockchain directory
//    String path_blockchain = "/home/nour/Documents/network/";
//    //The address of Crowdfactory Smartcontract
//    String addressCF = "0x692a70d2e424a56d2c6c27aa97d1a86395877b3a";
//    Web3j web3j = Web3j.build(new HttpService());
//    //Credentials
//    Credentials credentials = Credentials.create(privateKey);
//    //Credentials credentials=getCreds(addr,pass,type);
//
//    //add file to ipfs
//    @Override
//    public String add_file(String file_path) throws IOException {
//        try {
//            IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
//            NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(new File(file_path));
//            MerkleNode addResult = ipfs.add(file).get(0);
//            return addResult.hash.toString();
//        } catch (Exception e) {
//            System.out.println("Bad file Path.");
//            return null;
//        }
//
//    }
//
//    //read data from the ipfs
//    @Override
//    public String read_data(String hash_file) throws IOException, JSONException {
//        IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
//        Multihash filePointer = Multihash.fromBase58(hash_file);
//        byte[] fileContents = ipfs.cat(filePointer);
//        String s = Base64.getEncoder().encodeToString(fileContents);
//        String data_file = new JSONObject(new String(fileContents)).toString();
//
//        return data_file;
//    }
//
//    //send info and the hashfile to the smartcontract
////    @Override
////    public TransactionReceipt send_info_smartcontract(DataStored sent) throws Exception {
//////        try {
////            sent.setHash_data(add_file(sent.getPath()));
////            CrowdFactory contract= CrowdFactory.load(
////                    addressCF, web3j,credentials,ManagedTransaction.GAS_PRICE, BigInteger.valueOf(1000000));
////            return contract.setKYCData(sent.getHash_data(),sent.getTitle(),sent.getDescription(),sent.getOwner_name(),sent.getTypee(),sent.getAccess(),sent.getDate()).send();
////        }
////        catch (Exception e){
////            System.out.println("Bad file Path.");
////            return null;
////        }
////
////    }
//
//    //Read the data and the hashfile from the smartcontract
////    @Override
////    public Tuple7<BigInteger, String, String, String, String, String, String> get_data_from_smartcontract(int id, String addr, String pass, String type) throws Exception {
////
//////        SCS contract = SCS.load(
//////                address_SC1, web3j,credentials,ManagedTransaction.GAS_PRICE, BigInteger.valueOf(1000000));
//////
//////        Tuple7<BigInteger, String, String, String, String, String, String> x = contract.getData(BigInteger.valueOf(id)).send();
//////        return x;
//////    }
//////
//////    //Get the id of client who have access to the data
//////    @Override
//////    public List Get_idtable(String _access, String addr, String pass, String type) throws Exception {
//////        SCS contract=SCS.load(
//////                address_SC1, web3j,credentials,ManagedTransaction.GAS_PRICE, BigInteger.valueOf(1000000));
//////        contract.getHashbyaccess(_access).send();
//////        return contract.getaccessList().send();
////
////    }
////
////    //Get the list of client who have access to the data
////    @Override
////    public ArrayList<Tuple7<BigInteger, String, String, String, String, String, String>> get_listadded(String addr, String pass, String type, String _access) throws Exception {
////        SCS contract=SCS.load(address_SC1, web3j,credentials,ManagedTransaction.GAS_PRICE, BigInteger.valueOf(1000000));
////        ArrayList< Tuple7<BigInteger, String, String, String, String, String, String> > list = new ArrayList< Tuple7<BigInteger, String, String, String, String, String, String> >();
////        Tuple7<BigInteger, String, String, String, String, String, String> dataobject;
////        List x;
////        x=Get_idtable(_access,addr,pass,type);
////        BigInteger id;
////        for (int i=0;i<x.size();i++){
////            id=(BigInteger)x.get(i);
////            dataobject=contract.getData(id).send();
////            list.add(i,dataobject);
////        }
////        return list;
////
////    }
//
//    //Connect with the selected wallet
//    @Override
//    public Credentials getCreds(String address, String pass, String type) throws IOException, CipherException {
//        ArrayList<String> arrayList = listPathWallet(type);
//        switch (type) {
//            case "user":
//                for (int i = 0; i < arrayList.size(); i++) {
//                    try {
//                        if (arrayList.get(i).substring(46, arrayList.get(i).length() - 5).equalsIgnoreCase(address)) {
//                            return WalletUtils.loadCredentials(pass, path_blockchain + "db/" + arrayList.get(i));
//                        }
//                    } catch (Exception e) {
//                    }
//                }
//        }
//
//        return null;
//    }
//
//    //The list of wallets in the selected node
//    @Override
//    public ArrayList<String> listPathWallet(String type) throws IOException {
//        ArrayList<String> arrayList = new ArrayList<String>();
//        switch (type) {
//            case "user":
//                Files.newDirectoryStream(Paths.get(path_blockchain + "db/keystore/"),
//                        path -> path.toString().endsWith(""))
//                        .forEach(e -> arrayList.add(e.toString().substring(47)));
//                break;
//
//        }
//        return arrayList;
//
//    }
//
//        //Get the list of all the blocks in the Blockchain
//        public ArrayList<Block> listBlock ()throws IOException {
//            ArrayList<Block> arrayBlock = new ArrayList<Block>();
//
//            for (int i = 0; i < web3j.ethBlockNumber().send().getBlockNumber().intValue(); i++) {
//                Block block = new Block();
//                web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getParentHash();
//                block.setDifficulty(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getDifficulty().longValue());
//                block.setExtraData(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getExtraData());
//                block.setGasLimit(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getGasLimit().longValue());
//                block.setParentHash(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getParentHash());
//                block.setGasUsed(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getGasUsed().longValue());
//                block.setHash(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getHash());
//                block.setLogsBloom(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getLogsBloom());
//                block.setMiner(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getMiner());
//                block.setMixHash(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getMixHash());
//                block.setNonce(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getNonce().toString());
//                block.setNumber(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getNumber().longValue());
//                block.setReceiptsRoot(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getReceiptsRoot());
//                block.setSha3Uncles(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getSha3Uncles());
//                block.setSize(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getSize().intValue());
//                block.setStateRoot(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getStateRoot());
//                block.setTimestamp(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getTimestamp().longValue());
//                block.setTotalDifficulty(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getTotalDifficulty().longValue());
//                block.setTransactions(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getTransactions());
//                block.setTransactionsRoot(web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getTransactionsRoot());
//                block.setUncles((ArrayList<String>) web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), true).send().getBlock().getUncles());
//
//                arrayBlock.add(block);
//            }
//            return arrayBlock;
//        }
//
//        //Get the list of all the transactions in the Blockchain
////        public ArrayList<Transaction> listTransaction ()throws IOException {
////
////            ArrayList<Block> arrayBlock = this.listBlock();
////
////            ArrayList<Transaction> arrayList = new ArrayList<Transaction>();
////            for (int i = 0; i < arrayBlock.size(); i++) {
////                if (!(arrayBlock.get(i).getTransactions().isEmpty())) {
////                    for (int j = 0; j < arrayBlock.get(i).getTransactions().size(); j++) {
////                        Transaction transaction = new Transaction();
////
////                        transaction.setHash(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getHash());
////                        transaction.setNonce(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getNonce().toString());
////                        transaction.setBlockHash(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getBlockHash());
////                        transaction.setBlockNumber(String.valueOf(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getBlockNumber().longValue()));
////                        transaction.setTransactionIndex(String.valueOf(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getTransactionIndex().intValue()));
////                        transaction.setFrom(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getFrom());
////                        transaction.setTo(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getTo());
////                        transaction.setValue(String.valueOf(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getValue().longValue()));
////                        transaction.setGasPrice(String.valueOf(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getGasPrice().longValue()));
////                        transaction.setGas(String.valueOf(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getGas().longValue()));
////                        transaction.setInput(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getInput());
////                        transaction.setCreates(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getCreates());
////                        transaction.setPublicKey(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getPublicKey());
////                        transaction.setRaw(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getRaw());
////                        transaction.setR(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getR());
////                        transaction.setV(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getV());
////                        transaction.setS(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getS());
////                        transaction.setNonceRaw(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getNonceRaw());
////                        transaction.setBlockNumberRaw(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getBlockNumberRaw());
////                        transaction.setGasPriceRaw(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getGasPriceRaw());
////                        transaction.setGasRaw(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getGasRaw());
////                        transaction.setTransactionIndexRaw(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getTransactionIndexRaw());
////                        transaction.setValueRaw(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getValueRaw());
////                        if (web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getChainId() == null) {
////                            transaction.setChainId(null);
////                        } else {
////                            transaction.setChainId(web3j.ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.valueOf(i)), BigInteger.valueOf(j)).send().getTransaction().get().getChainId().toString());
////
////                        }
////
////                        arrayList.add(transaction);
////
////                    }
////                }
////            }
////
////            return arrayList;
////
////
////        }
//
//    }
