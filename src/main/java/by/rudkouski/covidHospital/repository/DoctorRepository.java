package by.rudkouski.covidHospital.repository;

import by.rudkouski.covidHospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findDoctorBySurname(String surname);

}
