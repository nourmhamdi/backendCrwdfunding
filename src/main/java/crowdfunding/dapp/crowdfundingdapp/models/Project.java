//package crowdfunding.dapp.crowdfundingdapp.models;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import java.math.BigInteger;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//@Entity
//@Table(name = "Projects", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {
//                "title"
//        }),
//        @UniqueConstraint(columnNames = {
//                "contractAddress"}),
//
//})
//public class Project {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @NotBlank
//    private String  porteur; // address du porteur
//    @NotBlank
//    private String title;
//    @NotBlank
//    private BigInteger montantACollect ;
//    @NotBlank
//    private BigInteger montantCollect;
//    @NotBlank
//    private Date dateDeDebut;
//    @NotBlank
//    private Date  dateDeFin;
//    @NotBlank
//    private String contractAddress;  // address du projet
//    @Enumerated(EnumType.STRING)
//    @NotBlank
//    private ProjectStatus stat;
//
//
////    @OneToMany (fetch = FetchType.LAZY)
////    @JoinTable(name = "project_rewards", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "reward_id"))
////    private Set<Reward> rewards = new HashSet<>();
//
//}
