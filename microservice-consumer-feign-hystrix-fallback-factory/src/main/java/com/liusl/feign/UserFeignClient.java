package com.liusl.feign;

import com.liusl.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by l1 on 2017/9/5.
 * Feign接口
 */
@FeignClient(name = "provider",fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {
    @GetMapping(value = "/{id}")//此处“value”的值应该是传参的值，注意path的格式,例如：我要访问的是http://localhost:7086/movie/feign/{id},此处的value可以是："/{id}"
    public User findById(@PathVariable("id") Long id);
}
