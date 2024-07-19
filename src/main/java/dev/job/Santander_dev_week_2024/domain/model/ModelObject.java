package dev.job.Santander_dev_week_2024.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.repository.NoRepositoryBean;

@MappedSuperclass
public abstract class ModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
