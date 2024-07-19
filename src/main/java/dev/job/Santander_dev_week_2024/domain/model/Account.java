package dev.job.Santander_dev_week_2024.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "account")
public class Account extends ModelObject{
    @Column(unique = true)
    private String number;
    private String agency;
    @Column(precision = 2)
    private double balance;
    @Column(name = "additional_limit", precision = 2)
    private double limit;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
