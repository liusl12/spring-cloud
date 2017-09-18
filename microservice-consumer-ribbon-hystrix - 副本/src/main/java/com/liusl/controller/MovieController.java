package com.liusl.controller;

import com.liusl.entity.User;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * created by l1 on 2017/9/1.
 */
@RestController
public class MovieController {

    private static final org.slf4j.Logger LOOGER= LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;//负载均衡客户端API

    /*
    带容错能力的findById方法，如果访问失败时，会调用findByIdFallback方法，而不会因为多次调用失败后造成雪崩效应
     */
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/movie/hystrix/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://provider/"+id,User.class);
    }

    public User findByIdFallback(Long id){
        User user = new User();
        user.setId(-1L);
        user.setName("Hystrix熔断，默认用户！！！");
        return user;
    }

    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider");

        //打印当前选择的是哪个节点
        MovieController.LOOGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
