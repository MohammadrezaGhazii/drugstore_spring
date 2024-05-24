package ir.group3.drugstoreDemo.repository;

import ir.group3.drugstoreDemo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin , Long> {
    Optional<Admin> findByNationalId(String nationalId);
}
