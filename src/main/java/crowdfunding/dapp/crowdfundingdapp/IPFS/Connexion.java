package crowdfunding.dapp.crowdfundingdapp.IPFS;
import io.ipfs.api.IPFS;
import io.ipfs.multiaddr.MultiAddress;
public class Connexion {

        private IPFS ipfs;

        public Connexion() {
            this.ipfs = new IPFS(new MultiAddress("/ip4/127.0.0.1/tcp/5001"));
        }

        public IPFS getConnexion() {
            return this.ipfs;

        }
    }


