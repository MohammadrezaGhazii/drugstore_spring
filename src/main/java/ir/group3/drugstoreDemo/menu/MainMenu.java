package ir.group3.drugstoreDemo.menu;

import ir.group3.drugstoreDemo.entity.Admin;
import ir.group3.drugstoreDemo.service.AdminService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MainMenu {
    private final AdminService adminService;

    public MainMenu(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostConstruct
    public void runTest(){
//        registerAdmin();
        deleteById();
    }

    private void deleteById() {
        Long id = 2L;
        adminService.deleteById(id);
    }

    private void registerAdmin() {
        Admin admin = Admin
                .builder()
                .firstName("amir")
                .lastName("mohammadzadeh")
                .nationalId("2222")
                .password("2222")
                .build();
        Admin saveAdmin = adminService.save(admin);
    }
}
