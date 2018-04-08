package com.liusl.feign;


import com.liusl.entity.User;
import org.springframework.stereotype.Component;

/*
    如果在Feign中使用Hystrix，需要创建fallback类，并且实现UserFeignClient接口
 */
@Component
public class FeignClientFallback implements UserFeignClient{
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("利用feign调用提供者，调用失败fallback");
        return user;
    }
}