package crowdfunding.dapp.crowdfundingdapp.models;


public class Transaction {

    private String hash;
    private String nonce;
    private String   blockHash;
    private Long     blockNumber;
    private int       transactionIndex;
    private String     from;
    private String        to;
    private Long       value;
    private Long        gasPrice;
    private Long         gas;
    private String        input;
    private String         creates;
    private String         publicKey;
    private String          raw;
    private String          r;
    private String         s;
    private long          v;
    private String         nonceRaw;
    private String         blockNumberRaw;
    private String         gasPriceRaw;
    private String         gasRaw;
    private String          transactionIndexRaw;
    private String         valueRaw;
    private String         chainId;

    public Transaction() {
    }

    public Transaction(String hash, String nonce, String blockHash, Long blockNumber, int transactionIndex, String from, String to, Long value, Long gasPrice, Long gas, String input, String creates, String publicKey, String raw, String r, String s, int v, String nonceRaw, String blockNumberRaw, String gasPriceRaw, String gasRaw, String transactionIndexRaw, String valueRaw, String chainId) {
        this.hash = hash;
        this.nonce = nonce;
        this.blockHash = blockHash;
        this.blockNumber = blockNumber;
        this.transactionIndex = transactionIndex;
        this.from = from;
        this.to = to;
        this.value = value;
        this.gasPrice = gasPrice;
        this.gas = gas;
        this.input = input;
        this.creates = creates;
        this.publicKey = publicKey;
        this.raw = raw;
        this.r = r;
        this.s = s;
        this.v = v;
        this.nonceRaw = nonceRaw;
        this.blockNumberRaw = blockNumberRaw;
        this.gasPriceRaw = gasPriceRaw;
        this.gasRaw = gasRaw;
        this.transactionIndexRaw = transactionIndexRaw;
        this.valueRaw = valueRaw;
        this.chainId = chainId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public Long getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(Long blockNumber) {
        this.blockNumber = blockNumber;
    }

    public int getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(int transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(Long gasPrice) {
        this.gasPrice = gasPrice;
    }

    public Long getGas() {
        return gas;
    }

    public void setGas(Long gas) {
        this.gas = gas;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getCreates() {
        return creates;
    }

    public void setCreates(String creates) {
        this.creates = creates;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public long getV() {
        return v;
    }

    public void setV(long v) {
        this.v = v;
    }

    public String getNonceRaw() {
        return nonceRaw;
    }

    public void setNonceRaw(String nonceRaw) {
        this.nonceRaw = nonceRaw;
    }

    public String getBlockNumberRaw() {
        return blockNumberRaw;
    }

    public void setBlockNumberRaw(String blockNumberRaw) {
        this.blockNumberRaw = blockNumberRaw;
    }

    public String getGasPriceRaw() {
        return gasPriceRaw;
    }

    public void setGasPriceRaw(String gasPriceRaw) {
        this.gasPriceRaw = gasPriceRaw;
    }

    public String getGasRaw() {
        return gasRaw;
    }

    public void setGasRaw(String gasRaw) {
        this.gasRaw = gasRaw;
    }

    public String getTransactionIndexRaw() {
        return transactionIndexRaw;
    }

    public void setTransactionIndexRaw(String transactionIndexRaw) {
        this.transactionIndexRaw = transactionIndexRaw;
    }

    public String getValueRaw() {
        return valueRaw;
    }

    public void setValueRaw(String valueRaw) {
        this.valueRaw = valueRaw;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }
}
