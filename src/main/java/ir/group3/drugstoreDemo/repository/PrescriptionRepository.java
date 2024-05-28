package ir.group3.drugstoreDemo.repository;

import ir.group3.drugstoreDemo.entity.Prescription;
import ir.group3.drugstoreDemo.service.PrescriptionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

    @Query("SELECT new ir.group3.drugstoreDemo.service.PrescriptionDTO(p.totalPrice ,p.confirm,m.medicineName,m.inventory, " +
            "            m.price ,m.doesExist ) " +
            "            FROM Prescription p join Item i on p.id = i.prescription.id " +
            "            join Medicine m on m.id = i.medicine.id" +
            " where p.confirm IS NULL " +
            " AND p.totalPrice IS NULL ")
    List<PrescriptionDTO> findAllByConfirmNullAndTotalPriceNull();
}
