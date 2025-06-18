package com.SpringApplication.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @OneToOne
    @JoinColumn(name = "transactionId", nullable = false)
    private Transactions transaction;

    private LocalDateTime invoiceDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    private String status;

    private String paymentMethod;

    // No-argument constructor
    public Invoice() {
    }

    // All-arguments constructor
    public Invoice(Long invoiceId, Transactions transaction, LocalDateTime invoiceDate, BigDecimal totalAmount, String status, String paymentMethod) {
        this.invoiceId = invoiceId;
        this.transaction = transaction;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    // Getters
    public Long getInvoiceId() {
        return invoiceId;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setters
    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}