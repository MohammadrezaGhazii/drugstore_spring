package ir.group3.drugstoreDemo.repository;

import ir.group3.drugstoreDemo.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
}
