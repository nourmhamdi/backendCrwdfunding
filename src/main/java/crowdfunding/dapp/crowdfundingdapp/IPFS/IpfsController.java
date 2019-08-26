//package crowdfunding.dapp.crowdfundingdapp.IPFS;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import io.ipfs.api.IPFS;
//import io.ipfs.api.MerkleNode;
//import io.ipfs.api.NamedStreamable;
//import io.ipfs.multihash.Multihash;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.File;
//import java.io.IOException;
//@RestController
//
//public class IpfsController {
//
//
//
//        IPFS IPFSConnection;
//
//        public IpfsController() {
//
//            this.IPFSConnection = new Connexion().getConnexion();
//        }
//
//        @GetMapping("/writeFile")
//        public String write(){
//
//            NamedStreamable file = new NamedStreamable.FileWrapper(new File("......"));
//
//            MerkleNode addResult = null;
//            try {
//                addResult = IPFSConnection.add(file).get(0);
//                Multihash pointer = addResult.hash;
//                return pointer.toString();
//            } catch (IOException e) {
//                e.printStackTrace();
//                return e.getMessage();
//            }
//
//
//        }
//
//
//
//    }
