package by.rudkouski.covidHospital.repository;

import by.rudkouski.covidHospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findPatientBySurname(String surname);

}
