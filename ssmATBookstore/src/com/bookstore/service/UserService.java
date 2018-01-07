package com.bookstore.service;

import com.bookstore.dao.UserMapper;

import com.bookstore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public void addUser(User user){
        userMapper.insertUser(user);
    }
}
