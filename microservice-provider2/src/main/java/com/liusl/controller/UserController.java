package com.liusl.controller;

import com.liusl.entity.User;
import com.liusl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by l1 on 2017/8/31.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User user =  this.userRepository.findOne(id);
        return user;
    }
}
