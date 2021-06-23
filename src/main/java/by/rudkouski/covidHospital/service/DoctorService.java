package by.rudkouski.covidHospital.service;
import by.rudkouski.covidHospital.entity.Doctor;
import by.rudkouski.covidHospital.entity.DoctorSurnameIsExists;
import by.rudkouski.covidHospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(Doctor doctor) throws DoctorSurnameIsExists {
        Optional<Doctor> doctorBySurname = doctorRepository.findDoctorBySurname(doctor.getSurname());
        if (doctorBySurname.isEmpty()) {
            return doctorRepository.save(doctor);
        } else {
            throw new DoctorSurnameIsExists("DoctorSurnameAlreadyExists");

        }

    }
}