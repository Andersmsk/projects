package by.rudkouski.covidHospital.controller;

import by.rudkouski.covidHospital.entity.Doctor;
import by.rudkouski.covidHospital.entity.Patient;
import by.rudkouski.covidHospital.entity.PatientSurnameIsExists;
import by.rudkouski.covidHospital.service.DoctorService;
import by.rudkouski.covidHospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/hospital")
    public String findAllPatients(Model model) {
        List<Patient> allPatients = patientService.findAllPatients();
        model.addAttribute("patient", allPatients);
        return "patient";
    }

    @PostMapping("/hospital")
    public String createNewPatient(@Validated Patient patient, Model model){
        try {
            patientService.addPatient(patient);
            return "redirect/hospital";
        } catch (PatientSurnameIsExists exception){
            model.addAttribute( "error", exception.getMessage());
            model.addAttribute("patient", patientService.findAllPatients());
            return "hospital";
        }

    }
}
