package com.liusl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther liusl12
 * @date 2018/5/16.
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public String getUser(){
        return "Shunli Liu";
    }
    @GetMapping("/order")
    public String getOrder(){
        return "order";
    }
}
