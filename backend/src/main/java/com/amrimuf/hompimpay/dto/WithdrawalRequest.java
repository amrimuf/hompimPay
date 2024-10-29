package com.amrimuf.hompimpay.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WithdrawalRequest {
    @NotNull(message = "Amount is required")
    @Min(value = 0, message = "Amount must be a positive number")
    private Double amount;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    public WithdrawalRequest() {
    }

    // Constructor with parameters
    public WithdrawalRequest(Double amount, String accountNumber) {
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    // Getters and Setters
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
}