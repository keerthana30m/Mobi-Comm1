package com.SpringApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(unique = true, nullable = false, length = 15)
    private String mobileNumber;

    @Column(nullable = false)
    private String userName;

    @Column(unique = true, nullable = true)
    private String emailId;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "planId", nullable = true)
    private Plans plan;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'USER' CHECK (role = 'USER')")
    private String role;

    // No-argument constructor
    public Users() {
    }

    // All-arguments constructor
    public Users(Long userId, String mobileNumber, String userName, String emailId, String status, Plans plan, String role) {
        this.userId = userId;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.emailId = emailId;
        this.status = status;
        this.plan = plan;
        this.role = role;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getStatus() {
        return status;
    }

    public Plans getPlan() {
        return plan;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPlan(Plans plan) {
        this.plan = plan;
    }

    public void setRole(String role) {
        this.role = role;
    }
}