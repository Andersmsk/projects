package by.rudkouski.covidHospital.entity;

import org.springframework.context.annotation.Role;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table (name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotBlank(message = "Incorrect patient's name")
    private String name;
    @NotBlank(message = "Incorrect patient's surname")
    private String surname;
    @Min(value = 1, message = "Incorrect number, must 1-120")
    @Max(value = 120, message = "Incorrect number, must 1-120")
    private int age;
    @Min(value = 35, message = "Incorrect number, must 35-41")
    @Max(value = 41, message = "Incorrect number, must 35-41")
    private double temperature;
    @NotBlank(message = "Cannot be blank")
    private String zoneLocation;
    @NotBlank(message = "Cannot be blank")
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Role role;

    public LocalDate getDate() {
        return date;
    }

    public Role getRole() {
        return role;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getZoneLocation() {
        return zoneLocation;
    }

    public LocalDate getReceiptDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setZoneLocation(String zoneLocation) {
        this.zoneLocation = zoneLocation;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.date = receiptDate;
    }
}