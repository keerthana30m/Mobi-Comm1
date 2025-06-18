package com.SpringApplication.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recharge_history")
public class RechargeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plans plan;

    @OneToOne
    @JoinColumn(name = "transactionId", nullable = false)
    private Transactions transaction;

    private LocalDateTime rechargeDate;
    private String paymentMethod;
    private LocalDateTime rechargeEnd;
    private BigDecimal amountPaid;

    // No-argument constructor
    public RechargeHistory() {
    }

    // All-arguments constructor
    public RechargeHistory(Long historyId, Users user, Plans plan, Transactions transaction, LocalDateTime rechargeDate, String paymentMethod, LocalDateTime rechargeEnd, BigDecimal amountPaid) {
        this.historyId = historyId;
        this.user = user;
        this.plan = plan;
        this.transaction = transaction;
        this.rechargeDate = rechargeDate;
        this.paymentMethod = paymentMethod;
        this.rechargeEnd = rechargeEnd;
        this.amountPaid = amountPaid;
    }

    // Getters
    public Long getHistoryId() {
        return historyId;
    }

    public Users getUser() {
        return user;
    }

    public Plans getPlan() {
        return plan;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public LocalDateTime getRechargeDate() {
        return rechargeDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getRechargeEnd() {
        return rechargeEnd;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    // Setters
    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setPlan(Plans plan) {
        this.plan = plan;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
    }

    public void setRechargeDate(LocalDateTime rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setRechargeEnd(LocalDateTime rechargeEnd) {
        this.rechargeEnd = rechargeEnd;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }
}