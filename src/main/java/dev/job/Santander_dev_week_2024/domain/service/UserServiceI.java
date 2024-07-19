package dev.job.Santander_dev_week_2024.domain.service;

import dev.job.Santander_dev_week_2024.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface UserServiceI {
    public Optional<List<User>> findAll();
    public Optional<User> findByName(String name);
    public Optional<User> create(User user);
}
