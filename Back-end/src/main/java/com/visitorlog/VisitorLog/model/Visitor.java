package com.visitorlog.VisitorLog.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
public class Visitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    @Column(nullable = false, updatable = false)
    private LocalDateTime timeAndDate;

    private String imageUrl;

    @Column(nullable = false, updatable = false)
    private String uniqueCode;

    public Visitor() { }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visitor(String firstName,
                   String lastName,
                   String email,
                   String phone,
                   String address,
                   LocalDateTime timeAndDate,
                   String imageUrl,
                   String uniqueCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.timeAndDate = timeAndDate;
        this.imageUrl = imageUrl;
        this.uniqueCode = uniqueCode;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getTimeAndDate() { return timeAndDate; }

    public void setTimeAndDate(LocalDateTime timeAndDate) { this.timeAndDate=timeAndDate;}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUniqueCode() { return uniqueCode; }

    public void setUniqueCode(String uniqueCode) { this.uniqueCode = uniqueCode; }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", timeAndDate=" + timeAndDate +
                ", imageUrl='" + imageUrl + '\'' +
                ", uniqueCode='" + uniqueCode + '\'' +
                '}';
    }
}
