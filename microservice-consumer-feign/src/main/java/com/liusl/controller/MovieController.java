package com.liusl.controller;

import com.liusl.entity.User;
import com.liusl.feign.UserFeignClient;
import com.netflix.discovery.converters.Auto;
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
    private LoadBalancerClient loadBalancerClient;//负载均衡客户端API

    @Autowired
    private UserFeignClient userFeignClient;//自动装载自定义的feign客户端接口

    @GetMapping("/movie/feign/{id}")
    public User findById(@PathVariable Long id){
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider");

        //打印当前选择的是哪个节点
        MovieController.LOOGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
