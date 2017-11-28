package com.daProject.dao.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "sur_name")
    private String surName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name="password")
    private String password;
    @Column(name = "employment")
    private String employment;
    @Column(name = "role")
    private String role;

    public User() {}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getSurName() {
        return surName;
    }
    public void setSurName(String last_name) {
        this.surName = last_name;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmployment() { return employment; }
    public void setEmployment(String employment) { this.employment = employment; }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

}



