package com.liusl.feign;


import com.liusl.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
    如果在Feign中使用Hystrix，需要创建fallback类，并且实现UserFeignClient接口
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);//打印日志

    @Override
    public UserFeignClient create(Throwable cause){
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                FeignClientFallbackFactory.LOGGER.info("fallback;reason was:",cause);
                User user = new User();
                user.setId(-1L);
                user.setName("利用feign调用提供者，调用失败fallback");
                return user;
            }
        };
    }

}