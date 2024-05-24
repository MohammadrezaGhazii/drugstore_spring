package ir.group3.drugstoreDemo.repository;

import ir.group3.drugstoreDemo.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}
