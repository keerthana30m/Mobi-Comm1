package com.SpringApplication.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_data")
public class UserData {
    @Id
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Users user;

    @Embedded
    private Address address;

    private String simType;

    private LocalDate dob;

    private LocalDateTime timestamp;

    // No-argument constructor
    public UserData() {
    }

    // All-arguments constructor
    public UserData(Long userId, Users user, Address address, String simType, LocalDate dob, LocalDateTime timestamp) {
        this.userId = userId;
        this.user = user;
        this.address = address;
        this.simType = simType;
        this.dob = dob;
        this.timestamp = timestamp;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public Users getUser() {
        return user;
    }

    public Address getAddress() {
        return address;
    }

    public String getSimType() {
        return simType;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}