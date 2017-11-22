package com.daProject.dao.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {

    private long id;
    private String firstName;
    private String surName;
    //private int age;
    private String phoneNumber;
    private String password;
    private String employment;
    private String role;

    private Set<ValiData> valiData = new HashSet<>();

    public User(long id) {
        this.id = id;
    }

    public User() {}

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "valId")
    public Set<ValiData> getValiData() {
        return valiData;
    }
    public void setValiData(Set<ValiData> valiData) {
        this.valiData = valiData;
    }
    public void setValiData(ValiData vvaliData) {
        this.valiData.add(vvaliData);
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    @Column(name = "sur_name")
    public String getSurName() {
        return surName;
    }
    public void setSurName(String last_name) {
        this.surName = last_name;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Column(name="password")
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

   @Column(name = "employment")
    public String getEmployment() { return employment; }
    public void setEmployment(String employment) { this.employment = employment; }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }





    @Override
    public String toString() {
        return super.toString();
    }

   /* @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
*/

}



