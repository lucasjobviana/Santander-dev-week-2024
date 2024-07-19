package dev.job.Santander_dev_week_2024.domain.controller;

import dev.job.Santander_dev_week_2024.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

public interface UserControllerI {
    public ResponseEntity<List<User>> findAll();
    public ResponseEntity<User> create(User user);
}
