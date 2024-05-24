package ir.group3.drugstoreDemo.service;

import ir.group3.drugstoreDemo.entity.Admin;
import ir.group3.drugstoreDemo.exception.NotFoundEntityException;
import ir.group3.drugstoreDemo.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin save(Admin admin){
        String nationalId = admin.getNationalId();
        Optional<Admin> optionalAdmin = adminRepository.findByNationalId(nationalId);
        if (optionalAdmin.isPresent()){
            log.warn("Duplicate - admin with this national id : {} has exist !!!" , nationalId);
            return null;
        }
        else {
            Admin dbAdmin = adminRepository.save(admin);
            log.info("Admin is registered : {} " , dbAdmin);
            return dbAdmin;
        }
    }

    public void deleteById(Long id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        try {
            optionalAdmin.orElseThrow(
                    () -> new NotFoundEntityException(String.format("admin with id : %s not found" , id ))
            );
            Admin foundAdmin = optionalAdmin.get();
            adminRepository.deleteById(foundAdmin.getId());
            log.info("Admin with this id : {} has been deleted" , id );
        }
        catch (NotFoundEntityException e){
            log.warn(e.getMessage());
        }
    }
}
