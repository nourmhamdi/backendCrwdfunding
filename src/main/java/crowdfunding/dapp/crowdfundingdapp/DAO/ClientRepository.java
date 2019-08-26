package crowdfunding.dapp.crowdfundingdapp.Client;
import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface ClientRepository extends  JpaRepository<Client,Long> {

}
