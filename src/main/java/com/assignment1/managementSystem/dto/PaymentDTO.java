package com.assignment1.managementSystem.dto;

import java.time.LocalDate;

public class PaymentDTO {
    private Double amount;
    private LocalDate date;

    public PaymentDTO() {
    }

    public PaymentDTO(Double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
