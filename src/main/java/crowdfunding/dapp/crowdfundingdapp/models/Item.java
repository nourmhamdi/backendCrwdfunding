//package crowdfunding.dapp.crowdfundingdapp.models;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import java.math.BigInteger;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Item {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long itemID;
//    @NotBlank
//    private String   itemTitle;
//    @NotBlank
//    private BigInteger itemValue;
//    @NotBlank
//    private String itemDescription;
////    @OneToMany(fetch = FetchType.LAZY)
////    @JoinTable(name = "reward_items", joinColumns = @JoinColumn(name = "reward_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
////    private Set<Item> Items = new HashSet<>();
//}
