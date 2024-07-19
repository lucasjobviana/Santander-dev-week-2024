package dev.job.Santander_dev_week_2024.domain.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseItem extends ModelObject{
    private String icon;

    private String description;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
