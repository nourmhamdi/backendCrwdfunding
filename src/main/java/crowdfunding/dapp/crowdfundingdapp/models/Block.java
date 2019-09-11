//package crowdfunding.dapp.crowdfundingdapp.models;
//
//import org.web3j.protocol.core.methods.response.EthBlock;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Block {
//
//    private Long difficulty;
//    private  String extraData;
//    private Long gasLimit;
//    private  Long gasUsed;
//    private  String hash;
//    private  String logsBloom;
//    private String  miner;
//    private  String   mixHash;
//    private  String  nonce;
//    private  Long number;
//    private String parentHash;
//    private String receiptsRoot;
//    private String  sha3Uncles;
//    private int size;
//    private String stateRoot;
//    private Long timestamp;
//    private Long   totalDifficulty;
//    private List<EthBlock.TransactionResult> transactions;
//    private String transactionsRoot;
//    private ArrayList<String>  uncles;
//
//    public Block() {
//    }
//
//    public Block(Long difficulty, String extraData, Long gasLimit, Long gasUsed, String hash, String logsBloom, String miner, String mixHash, String nonce, Long number, String parentHash, String receiptsRoot, String sha3Uncles, int size, String stateRoot, Long timestamp, Long totalDifficulty, List<EthBlock.TransactionResult> transactions, String transactionsRoot, ArrayList<String> uncles) {
//        this.difficulty = difficulty;
//        this.extraData = extraData;
//        this.gasLimit = gasLimit;
//        this.gasUsed = gasUsed;
//        this.hash = hash;
//        this.logsBloom = logsBloom;
//        this.miner = miner;
//        this.mixHash = mixHash;
//        this.nonce = nonce;
//        this.number = number;
//        this.parentHash = parentHash;
//        this.receiptsRoot = receiptsRoot;
//        this.sha3Uncles = sha3Uncles;
//        this.size = size;
//        this.stateRoot = stateRoot;
//        this.timestamp = timestamp;
//        this.totalDifficulty = totalDifficulty;
//        this.transactions = transactions;
//        this.transactionsRoot = transactionsRoot;
//        this.uncles = uncles;
//    }
//
//    public Long getDifficulty() {
//        return difficulty;
//    }
//
//    public void setDifficulty(Long difficulty) {
//        this.difficulty = difficulty;
//    }
//
//    public String getExtraData() {
//        return extraData;
//    }
//
//    public void setExtraData(String extraData) {
//        this.extraData = extraData;
//    }
//
//    public Long getGasLimit() {
//        return gasLimit;
//    }
//
//    public void setGasLimit(Long gasLimit) {
//        this.gasLimit = gasLimit;
//    }
//
//    public Long getGasUsed() {
//        return gasUsed;
//    }
//
//    public void setGasUsed(Long gasUsed) {
//        this.gasUsed = gasUsed;
//    }
//
//    public String getHash() {
//        return hash;
//    }
//
//    public void setHash(String hash) {
//        this.hash = hash;
//    }
//
//    public String getLogsBloom() {
//        return logsBloom;
//    }
//
//    public void setLogsBloom(String logsBloom) {
//        this.logsBloom = logsBloom;
//    }
//
//    public String getMiner() {
//        return miner;
//    }
//
//    public void setMiner(String miner) {
//        this.miner = miner;
//    }
//
//    public String getMixHash() {
//        return mixHash;
//    }
//
//    public void setMixHash(String mixHash) {
//        this.mixHash = mixHash;
//    }
//
//    public String getNonce() {
//        return nonce;
//    }
//
//    public void setNonce(String nonce) {
//        this.nonce = nonce;
//    }
//
//    public Long getNumber() {
//        return number;
//    }
//
//    public void setNumber(Long number) {
//        this.number = number;
//    }
//
//    public String getParentHash() {
//        return parentHash;
//    }
//
//    public void setParentHash(String parentHash) {
//        this.parentHash = parentHash;
//    }
//
//    public String getReceiptsRoot() {
//        return receiptsRoot;
//    }
//
//    public void setReceiptsRoot(String receiptsRoot) {
//        this.receiptsRoot = receiptsRoot;
//    }
//
//    public String getSha3Uncles() {
//        return sha3Uncles;
//    }
//
//    public void setSha3Uncles(String sha3Uncles) {
//        this.sha3Uncles = sha3Uncles;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }
//
//    public String getStateRoot() {
//        return stateRoot;
//    }
//
//    public void setStateRoot(String stateRoot) {
//        this.stateRoot = stateRoot;
//    }
//
//    public Long getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Long timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public Long getTotalDifficulty() {
//        return totalDifficulty;
//    }
//
//    public void setTotalDifficulty(Long totalDifficulty) {
//        this.totalDifficulty = totalDifficulty;
//    }
//
//    public List<EthBlock.TransactionResult> getTransactions() {
//        return transactions;
//    }
//
//    public void setTransactions(List<EthBlock.TransactionResult> transactions) {
//        this.transactions = transactions;
//    }
//
//    public String getTransactionsRoot() {
//        return transactionsRoot;
//    }
//
//    public void setTransactionsRoot(String transactionsRoot) {
//        this.transactionsRoot = transactionsRoot;
//    }
//
//    public ArrayList<String> getUncles() {
//        return uncles;
//    }
//
//    public void setUncles(ArrayList<String> uncles) {
//        this.uncles = uncles;
//    }
//}
