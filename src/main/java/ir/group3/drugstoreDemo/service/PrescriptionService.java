package ir.group3.drugstoreDemo.service;

import ir.group3.drugstoreDemo.entity.Patient;
import ir.group3.drugstoreDemo.entity.Prescription;
import ir.group3.drugstoreDemo.exception.NotFoundEntityException;
import ir.group3.drugstoreDemo.repository.PrescriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Prescription savePrescription(Prescription prescription) {
        Prescription dbPrescription = prescriptionRepository.save(prescription);
        log.info("Prescription added : {}" , dbPrescription);
        return dbPrescription;
    }

    public Prescription findById(long id) {
        Optional<Prescription> optionalPrescription = prescriptionRepository.findById(id);
        try {
            optionalPrescription.orElseThrow(
                    () -> new NotFoundEntityException(String.format("prescription with id : %s not found ",id))
            );
            Prescription prescription = optionalPrescription.get();
            log.info("prescription with this id : {} found" , id);
            return prescription;
        }
        catch (NotFoundEntityException e){
            log.warn(e.getMessage());
            return null;
        }
    }
}
