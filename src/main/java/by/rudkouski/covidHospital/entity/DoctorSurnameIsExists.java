package by.rudkouski.covidHospital.entity;

public class DoctorSurnameIsExists extends Exception{

    public DoctorSurnameIsExists(String message) {
        super(message);
    }
    @Override
    public String toString() {
        return "MyException{"
                + ", message=" + getMessage()
                + "} ";
    }
}
