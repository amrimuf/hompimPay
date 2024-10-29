package com.amrimuf.hompimpay.dto;

import java.time.LocalDateTime;

public class WithdrawalResponse {
    private Long id;
    private Double amount;
    private String accountNumber;
    private LocalDateTime createdAt;

    // Default constructor
    public WithdrawalResponse() {
    }

    // Constructor with parameters
    public WithdrawalResponse(Long id, Double amount, String accountNumber, LocalDateTime createdAt) {
        this.id = id;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}