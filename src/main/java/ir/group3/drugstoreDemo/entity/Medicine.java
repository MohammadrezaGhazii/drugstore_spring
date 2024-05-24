package ir.group3.drugstoreDemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name = "medicine_name")
    private String medicineName;

    @Column(name = "invetory")
    private Integer inventory;

    @Column(name = "does_exist")
    private Boolean doesExist;

    @Column(name = "price")
    private BigDecimal price;

    @ToString.Exclude
    @OneToMany(mappedBy = "medicine" , cascade = {CascadeType.PERSIST , CascadeType.DETACH ,
            CascadeType.MERGE , CascadeType.REFRESH})
    private List<Item> items;
}
