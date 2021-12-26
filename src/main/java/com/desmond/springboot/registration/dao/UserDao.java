package com.desmond.springboot.registration.dao;

import com.desmond.springboot.registration.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    void addUser(User user);
    User findByUsername(String username);
}
