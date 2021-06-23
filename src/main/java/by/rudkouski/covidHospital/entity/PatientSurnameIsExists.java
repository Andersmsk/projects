package by.rudkouski.covidHospital.entity;

public class PatientSurnameIsExists extends Exception{
    public PatientSurnameIsExists(String message) {
        super(message);
    }
    @Override
    public String toString() {
        return "MyException{"
                + ", message=" + getMessage()
                + "} ";
    }
}
