package edu.tcu.cs.frogcrew.user;

import edu.tcu.cs.frogcrew.system.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "email is required.")
    private String email;

    @NotEmpty(message = "password is required.")
    private String password;

    private int phoneNumber;

    private String firstName;

    private String lastName;

    private Role role;

    @ElementCollection
    private List<String> qualifiedPositions;

    private String payRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getQualifiedPositions() {
        return qualifiedPositions;
    }

    public void setQualifiedPositions(List<String> qualifiedPositions) {
        this.qualifiedPositions = qualifiedPositions;
    }

    public String getPayRate() {
        return payRate;
    }

    public void setPayRate(String payRate) {
        this.payRate = payRate;
    }

    public void register() {
    }

    public void login() {

    }

    public void invite() {

    }

}
