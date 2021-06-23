package by.rudkouski.covidHospital.service;

import by.rudkouski.covidHospital.entity.Patient;
import by.rudkouski.covidHospital.entity.PatientSurnameIsExists;
import by.rudkouski.covidHospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public List<Patient> findAllPatients(){
       return patientRepository.findAll();
    }

    public void addPatient(Patient patient) throws PatientSurnameIsExists {
        Optional<Patient> patientBySurname = patientRepository.findPatientBySurname((patient.getSurname()));
        if (patientBySurname.isEmpty()) {
            patientRepository.save(patient);
        } else {
                throw new PatientSurnameIsExists("PatientAlreadyExists");
        }

    }
}

