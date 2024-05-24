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
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "confirm")
    private Boolean confirm;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @ToString.Exclude
    @OneToMany(mappedBy = "prescription", cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
