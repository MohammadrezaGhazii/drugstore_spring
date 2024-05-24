package ir.group3.drugstoreDemo.repository;

import ir.group3.drugstoreDemo.entity.Admin;
import ir.group3.drugstoreDemo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findByNationalId(String nationalId);
}
