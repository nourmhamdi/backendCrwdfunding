package crowdfunding.dapp.crowdfundingdapp.DAO;

import crowdfunding.dapp.crowdfundingdapp.Models.CLient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<CLient, Long> {

    Optional<CLient> findByUsername(String email);

    Boolean existsByAddress(String address);
    Boolean existsByUsername(String email);

    Boolean existsByEmail(String email);

//    @Query("select  c from  CLient  c where c.name like :x ")
//    public Page <CLient> chercher (String mc, Pageable pageable);


}

