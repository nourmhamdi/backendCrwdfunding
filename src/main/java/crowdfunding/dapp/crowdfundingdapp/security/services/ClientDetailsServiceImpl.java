package crowdfunding.dapp.crowdfundingdapp.security.services;

import crowdfunding.dapp.crowdfundingdapp.DAO.ClientRepository;
import crowdfunding.dapp.crowdfundingdapp.Models.CLient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service

public class ClientDetailsServiceImpl implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        CLient user = clientRepository.findByUsername(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email : " + email)
                );

        return ClientPrinciple.build(user);
    }
}
