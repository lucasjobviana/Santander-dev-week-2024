package dev.job.Santander_dev_week_2024.domain.repository;

import dev.job.Santander_dev_week_2024.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByName(String name);
    public boolean existsByAccountNumber(String number);
}
