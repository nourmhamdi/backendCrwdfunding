package crowdfunding.dapp.crowdfundingdapp.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import crowdfunding.dapp.crowdfundingdapp.Models.CLient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import java.util.stream.Collectors;

public class ClientPrinciple implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;

    private String name;
    private String lastName;
    private String email;
    private String address;
    private Date birthday;
    private String pays;
    private String ville;
    private Long phoneNumber;
    private String photos;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public ClientPrinciple(Long id, String name, String lastName, String email, Date birthday, String pays, String ville, Long phoneNumber, String address, String photos, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username=email;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.pays = pays;
        this.ville = ville;
        this.phoneNumber = phoneNumber;
        this.photos = photos;
        this.password = password;
        this.address = address;
        this.authorities = authorities;
    }

    public static ClientPrinciple build(CLient client) {
        List<GrantedAuthority> authorities = client.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

        return new ClientPrinciple(client.getId(), client.getName(), client.getLastname(), client.getEmail(),
                client.getBirthday(), client.getPays(), client.getVille(), client.getPhonenumber(),
                client.getPhotos(), client.getPassword(), client.getAddress() ,authorities);
    }

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public String getAddress() {
        return address;
    }


    public Date getBirthday() {
        return birthday;
    }


    public String getPays() {
        return pays;
    }



    public String getVille() {
        return ville;
    }



    public Long getPhoneNumber() {
        return phoneNumber;
    }



    public String getPhotos() {
        return photos;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;

    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientPrinciple user = (ClientPrinciple) o;
        return Objects.equals(id, user.id);
    }
}
