//package crowdfunding.dapp.crowdfundingdapp.controllers;
//
//import crowdfunding.dapp.crowdfundingdapp.DAO.ClientRepository;
//import crowdfunding.dapp.crowdfundingdapp.Entities.CLient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.web.bind.annotation.*;
//
//import java.awt.print.Pageable;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//
//
//public class ClientRestController {
//
//
//    @Autowired
//    private ClientRepository Clientrep;
//
//    @RequestMapping(value = "/clients", method = RequestMethod.GET)
//    public List<CLient> getCleints(){
//        return  Clientrep.findAll();
//    }
//
//    @RequestMapping(value = "/ChercherClients", method = RequestMethod.GET)
//    public Page <CLient> chercher(@RequestParam(name = "mc", defaultValue = "") String mc,
//                               @RequestParam(name = "page", defaultValue = "0") int page,
//                               @RequestParam(name = "size", defaultValue = "5") int size ){
//        return  Clientrep.chercher(mc, (Pageable) new PageRequest(page,size));
//    }
//
//    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
//    public Optional<CLient> getCleint(@PathVariable  Long id){
//        return  Clientrep.findById(id);
//    }
//
//
//    @RequestMapping(value = "/clients", method = RequestMethod.POST)
//    public CLient save (@RequestBody CLient c){
//        return  Clientrep.save(c);
//    }
//
//    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
//    public boolean  supprimer (@PathVariable Long id){
//       Clientrep.deleteById(id);
//       return  true;
//    }
//    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
//    public CLient mettreAJour (@PathVariable Long id, @RequestBody CLient c){
//        c.setId(id);
//        return  Clientrep.save(c);
//    }
//}
