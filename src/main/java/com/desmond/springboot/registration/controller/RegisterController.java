package com.desmond.springboot.registration.controller;

import com.desmond.springboot.registration.model.User;
import com.desmond.springboot.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody User userObject) {
        User foundUser = userService.findByUsername(userObject.getUsername());

        if(foundUser != null){
            //Username exists
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            userService.addUser(userObject);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
