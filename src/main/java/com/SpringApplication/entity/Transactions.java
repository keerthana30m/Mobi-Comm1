package com.SpringApplication.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "planId", nullable = false)
    private Plans plan;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String paymentStatus;

    private LocalDateTime paymentDate;

    // No-argument constructor
    public Transactions() {
    }

    // All-arguments constructor
    public Transactions(String transactionId, Users user, Plans plan, String paymentMethod, String paymentStatus, LocalDateTime paymentDate) {
        this.transactionId = transactionId;
        this.user = user;
        this.plan = plan;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public Users getUser() {
        return user;
    }

    public Plans getPlan() {
        return plan;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    // Setters
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setPlan(Plans plan) {
        this.plan = plan;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}