package crowdfunding.dapp.crowdfundingdapp.auth.repository;

import crowdfunding.dapp.crowdfundingdapp.auth.model.Role;
import crowdfunding.dapp.crowdfundingdapp.auth.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
