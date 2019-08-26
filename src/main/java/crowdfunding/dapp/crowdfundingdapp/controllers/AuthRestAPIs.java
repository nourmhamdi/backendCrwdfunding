package crowdfunding.dapp.crowdfundingdapp.controllers;

import crowdfunding.dapp.crowdfundingdapp.DAO.ClientRepository;
import crowdfunding.dapp.crowdfundingdapp.DAO.RoleRepository;
import crowdfunding.dapp.crowdfundingdapp.Models.CLient;
import crowdfunding.dapp.crowdfundingdapp.Models.Role;
import crowdfunding.dapp.crowdfundingdapp.Models.RoleName;
import crowdfunding.dapp.crowdfundingdapp.message.request.LoginForm;
import crowdfunding.dapp.crowdfundingdapp.message.request.signUpform;
import crowdfunding.dapp.crowdfundingdapp.message.response.JwtResponse;
import crowdfunding.dapp.crowdfundingdapp.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder ;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails clientDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                clientDetails.getUsername(), clientDetails.getAuthorities()));

    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody signUpform signUpRequest) {
        if (clientRepository.existsByAddress(signUpRequest.getAddress())) {  // içi je vais changer en add ethereum
            return new ResponseEntity<String>("Fail -> Cette est déja utilisé !",
                    HttpStatus.BAD_REQUEST);
        }

        if (clientRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email déja utilisé !",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account

        CLient user = new CLient(signUpRequest.getName(), signUpRequest.getLastName(), signUpRequest.getAddress(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()), signUpRequest.getBirthday(),
                signUpRequest.getPays(), signUpRequest.getVille(), signUpRequest.getPhonenumber(), signUpRequest.getPhotos());


        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {

            Role userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
            roles.add(userRole);

        });

        user.setRoles(roles);
        clientRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }
}
