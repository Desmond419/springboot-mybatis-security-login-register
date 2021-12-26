package com.desmond.springboot.registration.service;

import com.desmond.springboot.registration.model.User;

public interface UserService {
    void addUser(User user);
    User findByUsername(String username);
}
