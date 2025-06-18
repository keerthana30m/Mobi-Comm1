package com.SpringApplication.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "plans")
public class Plans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    private String planCategory;
    private String planName;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal planPrice;

    private Integer validityDays;
    private String planData;
    private String features;
    private LocalDateTime createdAt;
    private String planStatus;

    // No-argument constructor
    public Plans() {
    }

    // All-arguments constructor
    public Plans(Long planId, String planCategory, String planName, BigDecimal planPrice, Integer validityDays, String planData, String features, LocalDateTime createdAt, String planStatus) {
        this.planId = planId;
        this.planCategory = planCategory;
        this.planName = planName;
        this.planPrice = planPrice;
        this.validityDays = validityDays;
        this.planData = planData;
        this.features = features;
        this.createdAt = createdAt;
        this.planStatus = planStatus;
    }

    // Getters
    public Long getPlanId() {
        return planId;
    }

    public String getPlanCategory() {
        return planCategory;
    }

    public String getPlanName() {
        return planName;
    }

    public BigDecimal getPlanPrice() {
        return planPrice;
    }

    public Integer getValidityDays() {
        return validityDays;
    }

    public String getPlanData() {
        return planData;
    }

    public String getFeatures() {
        return features;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getPlanStatus() {
        return planStatus;
    }

    // Setters
    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public void setPlanCategory(String planCategory) {
        this.planCategory = planCategory;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setPlanPrice(BigDecimal planPrice) {
        this.planPrice = planPrice;
    }

    public void setValidityDays(Integer validityDays) {
        this.validityDays = validityDays;
    }

    public void setPlanData(String planData) {
        this.planData = planData;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }
}
