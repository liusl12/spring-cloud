package com.liusl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @auther liusl12
 * @date 2018/2/28.
 */
@SpringBootApplication
@EnableConfigServer
public class MicroserviceConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConfigServerApplication.class, args);
    }
}
