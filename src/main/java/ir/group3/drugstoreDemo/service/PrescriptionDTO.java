package ir.group3.drugstoreDemo.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PrescriptionDTO {
    private BigDecimal totalPrice;
    private Boolean confirm;
    private String medicineName;
    private Integer inventory;
    private BigDecimal price;
    private Boolean doesExist;

    public PrescriptionDTO(BigDecimal totalPrice, Boolean confirm, String medicineName,
                           Integer inventory, BigDecimal price, Boolean doesExist) {
        this.totalPrice = totalPrice;
        this.confirm = confirm;
        this.medicineName = medicineName;
        this.inventory = inventory;
        this.price = price;
        this.doesExist = doesExist;
    }
}
