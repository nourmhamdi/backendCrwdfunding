package crowdfunding.dapp.crowdfundingdapp.auth.controller;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import crowdfunding.dapp.crowdfundingdapp.auth.message.request.LoginForm;
import crowdfunding.dapp.crowdfundingdapp.auth.message.request.SignUpForm;
import crowdfunding.dapp.crowdfundingdapp.auth.message.response.JwtResponse;
import crowdfunding.dapp.crowdfundingdapp.auth.message.response.ResponseMessage;
import crowdfunding.dapp.crowdfundingdapp.auth.model.Role;
import crowdfunding.dapp.crowdfundingdapp.auth.model.RoleName;
import crowdfunding.dapp.crowdfundingdapp.auth.model.User;
import crowdfunding.dapp.crowdfundingdapp.auth.repository.RoleRepository;
import crowdfunding.dapp.crowdfundingdapp.auth.repository.UserRepository;
import crowdfunding.dapp.crowdfundingdapp.auth.security.jwt.JwtProvider;

//import crowdfunding.dapp.crowdfundingdapp.services.impl.CrowdFactoryServiceImpl;
import crowdfunding.dapp.crowdfundingdapp.services.impl.EthereumService;
//import crowdfunding.dapp.crowdfundingdapp.services.impl.RegistrationService;
import crowdfunding.dapp.crowdfundingdapp.services.impl.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {


    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;
    //*************
    @Autowired
    RegistrationService registrationService;
    @Autowired
    EthereumService ethereumService;
//*******************

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getAddress(), signUpRequest.getUsername(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;
                case "pm":
                    Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(pmRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });

        user.setRoles(roles);
//        user.setName(signUpRequest.getName());
//        user.setLastname(signUpRequest.getLastname());
//        user.setBirthday(signUpRequest.getBirthday());
//        user.setPays(signUpRequest.getPays());
//        user.setVille(signUpRequest.getVille());
//        user.setProfilpicture("hhhhhhh");
  try{
      System.out.print("1           kjqdhflgkmjetoigjÙL");
   registrationService.signUp(user);
      System.out.print("2           kjqdhflgkmjetoigjÙL");

      userRepository.save(user);
      System.out.print("3           kjqdhflgkmjetoigjÙL");

  }
  catch (Exception e){
      e.printStackTrace();
      return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.OK);
  }

        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
    }




    //---------------------------
    @PostMapping("/signup2")
    public ResponseEntity<?> registerBC(@Valid @RequestBody SignUpForm signUpRequest) {

        // Creating user's account
        User user = new User(signUpRequest.getAddress(), signUpRequest.getUsername(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

//        Set<String> strRoles = signUpRequest.getRole();
//        Set<Role> roles = new HashSet<>();
//     user.setRoles(roles);
//        user.setName(signUpRequest.getName());
//        user.setLastname(signUpRequest.getLastname());
//        user.setBirthday(signUpRequest.getBirthday());
//        user.setPays(signUpRequest.getPays());
//        user.setVille(signUpRequest.getVille());
//        user.setProfilpicture("hhhhhhh");
        try{
            System.out.print("1           kjqdhflgkmjetoigjÙL");
            registrationService.signUp(user);
            System.out.print("2           kjqdhflgkmjetoigjÙL");

            return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.OK);
        }



    }
}
