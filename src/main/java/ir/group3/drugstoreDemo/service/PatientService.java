package ir.group3.drugstoreDemo.service;

import ir.group3.drugstoreDemo.entity.Admin;
import ir.group3.drugstoreDemo.entity.Patient;
import ir.group3.drugstoreDemo.exception.NotFoundEntityException;
import ir.group3.drugstoreDemo.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient) {
        String nationalId = patient.getNationalId();
        Optional<Patient> optionalPatient = patientRepository.findByNationalId(nationalId);
        if (optionalPatient.isPresent()){
            log.warn("Duplicate - patient with this national id : {} has exist !!!" , nationalId);
            return null;
        }
        else {
            Patient dbPatient = patientRepository.save(patient);
            log.info("Patient is registered : {} " , dbPatient);
            return dbPatient;
        }
    }

    public Patient findByNationalId(String nationalId) {
        Optional<Patient> optionalPatient = patientRepository.findByNationalId(nationalId);

        try {
            optionalPatient.orElseThrow(
                    () -> new NotFoundEntityException(String.format("patient with national id : %s not found ",nationalId))
            );
            Patient patient = optionalPatient.get();
            log.info("patient with this national id : {} found" , nationalId);
            return patient;
        }
        catch (NotFoundEntityException e){
            log.warn(e.getMessage());
            return null;
        }

    }
}
