package com.SpringApplication.dto;


public class RechargeRequestDTO {
    private Long userId;
    private Long planId;
    private String paymentMethod;

    // No-argument constructor
    public RechargeRequestDTO() {
    }

    // All-arguments constructor
    public RechargeRequestDTO(Long userId, Long planId, String paymentMethod) {
        this.userId = userId;
        this.planId = planId;
        this.paymentMethod = paymentMethod;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public Long getPlanId() {
        return planId;
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

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}