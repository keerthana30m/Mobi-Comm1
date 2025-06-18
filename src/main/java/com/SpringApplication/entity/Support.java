package com.SpringApplication.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "support")
public class Support {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supportId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private Users user;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String emailId;

    private String issueCategory;
    private String description;
    private String status;
    private LocalDateTime createdAt;

    // No-argument constructor
    public Support() {
    }

    // All-arguments constructor
    public Support(Long supportId, Users user, String name, String emailId, String issueCategory, String description, String status, LocalDateTime createdAt) {
        this.supportId = supportId;
        this.user = user;
        this.name = name;
        this.emailId = emailId;
        this.issueCategory = issueCategory;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters
    public Long getSupportId() {
        return supportId;
    }

    public Users getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getIssueCategory() {
        return issueCategory;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setSupportId(Long supportId) {
        this.supportId = supportId;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setIssueCategory(String issueCategory) {
        this.issueCategory = issueCategory;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}