package dev.job.Santander_dev_week_2024.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "card")
public class Card extends ModelObject{
    @Column(unique = true)
    private String number;
    @Column(name = "available_limit", precision = 2)
    private double limit;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}

