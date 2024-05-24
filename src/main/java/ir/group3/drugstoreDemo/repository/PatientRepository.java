package ir.group3.drugstoreDemo.repository;

import ir.group3.drugstoreDemo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
