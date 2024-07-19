package dev.job.Santander_dev_week_2024.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity(name = "card")
public class Card extends ModelObject{
    @Column(unique = true)
    private String number;
    @Column(name = "available_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}

