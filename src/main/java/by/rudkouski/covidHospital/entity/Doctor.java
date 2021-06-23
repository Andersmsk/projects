package by.rudkouski.covidHospital.entity;

import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Role;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "Incorrect name")
    private String name;
    @NotBlank(message = "Incorrect surname")
    private String surname;
    @NotBlank(message = "Incorrect qualification")
    private String qualification;
    @NotBlank(message = "Cannot be blank")
    private String login;
    @Column(name="password")
    @NotBlank(message = "Cannot be blank")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getQualification() {
        return qualification;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
