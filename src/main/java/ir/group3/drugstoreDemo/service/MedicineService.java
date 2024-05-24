package ir.group3.drugstoreDemo.service;

import ir.group3.drugstoreDemo.entity.Medicine;
import ir.group3.drugstoreDemo.repository.MedicineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MedicineService {
    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public Medicine saveMedicine(Medicine medicine) {
        Medicine dbMedicine = medicineRepository.save(medicine);
        log.info("Medicine is added : {}" , medicine);
        return dbMedicine;
    }

    public List<Medicine> findAll() {
        return medicineRepository.findAll();
    }
}
