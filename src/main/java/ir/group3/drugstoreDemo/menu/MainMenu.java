package ir.group3.drugstoreDemo.menu;

import ir.group3.drugstoreDemo.entity.Admin;
import ir.group3.drugstoreDemo.service.AdminService;
import jakarta.annotation.PostConstruct;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.beans.MethodInvocationException.ERROR_CODE;

@Component
public class MainMenu {
    private final AdminService adminService;
    private final PasswordGenerator passwordGenerator;

    public MainMenu(AdminService adminService, PasswordGenerator passwordGenerator) {
        this.adminService = adminService;
        this.passwordGenerator = passwordGenerator;
    }

    @PostConstruct
    public void runTest(){
//        registerAdmin();
//        deleteById();
        update();
    }

    private void update() {
        Long id = 4L;
        Admin admin = Admin
                .builder()
                .lastName("hosseiny")
                .password(generateSecurePassword())
                .build();
        adminService.update(admin,id);
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
                .password(generateSecurePassword())
                .build();
        Admin saveAdmin = adminService.save(admin);
    }
    public String generateSecurePassword() {
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return ERROR_CODE;
            }

            public String getCharacters() {
                return "@#!%&*";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        return passwordGenerator.generatePassword(8, splCharRule, lowerCaseRule,
                upperCaseRule, digitRule);

    }
}
