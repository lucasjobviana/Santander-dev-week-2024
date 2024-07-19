package dev.job.Santander_dev_week_2024.domain.service;

import dev.job.Santander_dev_week_2024.domain.model.User;
import dev.job.Santander_dev_week_2024.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class UserServiceImp implements UserServiceI{
    private final UserRepository repository;
    @Autowired
    public UserServiceImp(UserRepository repository){
        this.repository = repository;
    }
    @Override
    public Optional<List<User>> findAll() {
        List<User> users = this.repository.findAll();
        if(users.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(users);
    }

    @Override
    public Optional<User> findByName(String name) {
        User user = this.repository.findByName(name);
        if(user.getId() == 0){
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public Optional<User> create(User user) {
//        if(this.repository.){}
//        user.getAccount().getNumber()
        if(this.repository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("This account number already exists.");
        }
        User userSaved = this.repository.save(user);
        if(Objects.equals(userSaved.getName(), user.getName())){
            return Optional.of(userSaved);
        }
        return Optional.empty();
    }
}
