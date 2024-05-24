package ir.group3.drugstoreDemo.menu;

import ir.group3.drugstoreDemo.entity.*;
import ir.group3.drugstoreDemo.service.*;
import jakarta.annotation.PostConstruct;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.beans.MethodInvocationException.ERROR_CODE;

@Component
public class MainMenu {
    private final AdminService adminService;
    private final MedicineService medicineService;
    private final PatientService patientService;
    private final ItemService itemService;
    private final PrescriptionService prescriptionService;


    private final PasswordGenerator passwordGenerator;


    public MainMenu(AdminService adminService, MedicineService medicineService, PasswordGenerator passwordGenerator, PatientService patientService, ItemService itemService, PrescriptionService prescriptionService) {
        this.adminService = adminService;
        this.medicineService = medicineService;
        this.passwordGenerator = passwordGenerator;
        this.patientService = patientService;
        this.itemService = itemService;
        this.prescriptionService = prescriptionService;
    }

    @PostConstruct
    public void runTest(){
     //  registerAdmin();
//      deleteById();
//        update();
 //       registerMedicine();
      //  registerPatient();
      //  registerItem();
      //  registerPrescription();
        listOfPrescription();
    }

    private void listOfPrescription() {
       // prescriptionService.listOfPrescription();
    }

    private void registerPrescription() {
        String nationalId = "3333";
        Patient patient = patientService.findByNationalId(nationalId);
        Prescription prescription = Prescription
                .builder()
                .patient(patient)
                .build();
        prescriptionService.savePrescription(prescription);
    }

    private void registerItem() {
        Prescription prescription = prescriptionService.findById(1L);
        List<Medicine> medicines = medicineService.findAll();
        for (Medicine medicine : medicines) {
            Item item = Item
                    .builder()
                    .numberOfItem(5)
                    .build();
            item.setMedicine(medicine);
            item.setPrescription(prescription);
            itemService.saveItem(item);
        }
    }

    private void registerPatient() {
        Patient patient = Patient
                .builder()
                .firstName("Asghar")
                .lastName("Shalgham")
                .nationalId("3333")
                .build();
        patientService.savePatient(patient);
    }

    private void registerMedicine() {
        Medicine medicine = Medicine
                .builder()
                .medicineName("staminofen")
                .price(BigDecimal.valueOf(40000L))
                .inventory(200)
                .doesExist(Boolean.TRUE)
                .build();
        medicineService.saveMedicine(medicine);
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
