package com.liusl.feign;

import com.liusl.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by l1 on 2017/9/5.
 * Feign接口
 */
@FeignClient(name = "provider")
public interface UserFeignClient {
    @GetMapping(value = "/movie/feign/{id}")
    public User findById(@PathVariable Long id);
}
