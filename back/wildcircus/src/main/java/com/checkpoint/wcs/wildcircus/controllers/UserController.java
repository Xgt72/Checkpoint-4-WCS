package com.checkpoint.wcs.wildcircus.controllers;

import com.checkpoint.wcs.wildcircus.entities.User;
import com.checkpoint.wcs.wildcircus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    public UserController() { }

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptEncoder;

    @Secured({"SUPER_ADMIN"})
    @GetMapping("/user")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Secured({"SUPER_ADMIN"})
    @GetMapping("/user/{id}")
    public User getOneById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @Secured({"SUPER_ADMIN"})
    @PostMapping("/user")
    public User create(@RequestBody User user) throws Exception {
        return userRepository.save(user);
    }

    @Secured({"SUPER_ADMIN"})
    @PutMapping("/user/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
        User current = userRepository.findById(id).get();

        if (user.getUsername() != null) {
            current.setUsername(user.getUsername());
        }
        if (user.getEmail() != null) {
            current.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            current.setPassword(bCryptEncoder.encode(user.getPassword()));;
        }
        if (user.getRole() != null) {
            current.setRole(user.getRole());
        }
        return userRepository.save(current);
    }

    @Secured({"SUPER_ADMIN"})
    @DeleteMapping("/user/{id}")
    public boolean delete(@PathVariable("id") Long id) throws Exception {
        userRepository.deleteById(id);
        return true;
    }
}
