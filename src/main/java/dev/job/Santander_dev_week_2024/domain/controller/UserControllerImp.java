package dev.job.Santander_dev_week_2024.domain.controller;

import dev.job.Santander_dev_week_2024.domain.model.User;
import dev.job.Santander_dev_week_2024.domain.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("/users")
public class UserControllerImp implements UserControllerI {
    private final UserServiceI service;
    @Autowired
    public  UserControllerImp(UserServiceI service){
        this.service = service;
    }
    @GetMapping
    @Override
    public ResponseEntity<List<User>> findAll() {
        Optional<List<User>> users = this.service.findAll();

        return users.map(userList -> ResponseEntity.status(HttpStatus.OK).body(userList)).orElseGet(() -> ResponseEntity.badRequest().build());
        //        return ResponseEntity.of(Optional.of(users.get()));

    }
    @PostMapping
    @Override
    public ResponseEntity<User> create(@RequestBody User user) {
        Optional<User> userCreated = this.service.create(user);

        return   userCreated
                .map(new Function<User, ResponseEntity<User>>() {
                         @Override
                         public ResponseEntity<User> apply(User user) {
                             final URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                     .path("/{id}")
                                     .buildAndExpand(user.getId())
                                     .toUri();
                             return ResponseEntity.created(location).body(user);
                         }


                }
//                        ResponseEntity.status(HttpStatus.CREATED).body(value)
                )
                .orElseGet(() ->
                        ResponseEntity.badRequest().build()
                );
    }
}
