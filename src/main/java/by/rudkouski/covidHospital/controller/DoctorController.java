package by.rudkouski.covidHospital.controller;

import by.rudkouski.covidHospital.entity.Doctor;
import by.rudkouski.covidHospital.entity.DoctorSurnameIsExists;
import by.rudkouski.covidHospital.entity.Patient;
import by.rudkouski.covidHospital.entity.PatientSurnameIsExists;
import by.rudkouski.covidHospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DoctorController {
    private  DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping("/hospital")
    public String findAllDoctors(Model model){
        List<Doctor> allDoctors = doctorService.findAllDoctors();
        model.addAttribute("doctor",allDoctors);
        return "doctors";
    }

    @PostMapping("/hospital")     //TODO разработать логику перевода пациента в ред зону и уайт зону, удаление пациента
    public String createNewPatient(@Validated Doctor doctor, Model model) {
        try {
            doctorService.addDoctor(doctor);
            return "redirect/hospital";
        } catch (DoctorSurnameIsExists exception) {
            model.addAttribute("error", exception.getMessage());
            model.addAttribute("patient", doctorService.findAllDoctors());
            return "hospital";
        }
    }
}
