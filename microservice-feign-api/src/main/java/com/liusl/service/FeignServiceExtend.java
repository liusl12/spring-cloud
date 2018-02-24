package com.liusl.service;


import com.liusl.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther liusl12
 * @date 2018/2/23.
 */
@RequestMapping("/refactor")
public interface FeignServiceExtend {
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id);
}
