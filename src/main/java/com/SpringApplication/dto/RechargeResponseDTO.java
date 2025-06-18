package com.SpringApplication.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RechargeResponseDTO {
    private Long userId;
    private Long planId;
    private String transactionId;
    private LocalDateTime startDate;
    private LocalDateTime expiryDate;
    private BigDecimal amountPaid;
    private String paymentMethod;

    // No-argument constructor
    public RechargeResponseDTO() {
    }

    // All-arguments constructor
    public RechargeResponseDTO(Long userId, Long planId, String transactionId, LocalDateTime startDate, LocalDateTime expiryDate, BigDecimal amountPaid, String paymentMethod) {
        this.userId = userId;
        this.planId = planId;
        this.transactionId = transactionId;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
        this.amountPaid = amountPaid;
        this.paymentMethod = paymentMethod;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public Long getPlanId() {
        return planId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
