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
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private Users user;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String emailId;

    private Integer rating;

    private String comments;

    private LocalDateTime submittedAt;

    // No-argument constructor
    public Feedback() {
    }

    // All-arguments constructor
    public Feedback(Long feedbackId, Users user, String name, String emailId, Integer rating, String comments, LocalDateTime submittedAt) {
        this.feedbackId = feedbackId;
        this.user = user;
        this.name = name;
        this.emailId = emailId;
        this.rating = rating;
        this.comments = comments;
        this.submittedAt = submittedAt;
    }

    // Getters
    public Long getFeedbackId() {
        return feedbackId;
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

    public Integer getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    // Setters
    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
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

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}