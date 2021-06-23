package by.rudkouski.covidHospital.entity;

import org.springframework.context.annotation.Role;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Table (name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private int age;
    private double temperature;
    private String zoneLocation;
    private LocalDate date;
    @Enumerated(EnumType.STRING)

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