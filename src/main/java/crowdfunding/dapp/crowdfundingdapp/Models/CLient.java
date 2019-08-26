package crowdfunding.dapp.crowdfundingdapp.Entities;
import lombok.*;
import org.hibernate.annotations.NaturalId;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
public class CLient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id ;

    @NotBlank
    @Size(min = 3, max = 50)
    private   @NonNull String name ;

    @NotBlank
    @Size(min = 3, max = 50)
    private   @NonNull String lastname;

    private   @NonNull String address; // addresse ethereum


    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private   @NonNull String email;

    @NotBlank
    @Size(min = 6, max = 100)
    private   @NonNull String password;


    public CLient(@NotBlank @Size(min = 3, max = 50) @NonNull String name, @NotBlank @Size(min = 3, max = 50) @NonNull String lastname, @NonNull String address, @NotBlank @Size(max = 50) @Email @NonNull String email, @NotBlank @Size(min = 6, max = 100) @NonNull String password, @NonNull Date birthday, @NonNull String pays, @NonNull String ville, Long phonenumber, String photos) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.pays = pays;
        this.ville = ville;
        this.phonenumber = phonenumber;
        this.photos = photos;
    }


    @Temporal(TemporalType.DATE)
    private   @NonNull Date birthday  ;

    private   @NonNull String pays ;
    private   @NonNull String ville;
    private   Long phonenumber ;
//    private   String cv ;
    private   String photos ;

    @ManyToMany(fetch =FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles =new HashSet<>();

    public CLient(String name, String lastname, String adress, String email, String password, Date birthday, String pays, String ville, long number, String cv, String photos) {
//
//        this.name = name;
//        this.lastname = lastname;
//        this.adress = adress;
        this.email = email;
        this.password = password;
//        this.birthday = birthday;
//        this.pays = pays;
//        this.ville = ville;
//        this.number = number;
//        this.cv = cv;
//        this.photos = photos;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }



    

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
