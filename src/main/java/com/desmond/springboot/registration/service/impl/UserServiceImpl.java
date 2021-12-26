package com.desmond.springboot.registration.service.impl;

import com.desmond.springboot.registration.dao.UserDao;
import com.desmond.springboot.registration.model.User;
import com.desmond.springboot.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User findByUsername(String name){
        return userDao.findByUsername(name);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
