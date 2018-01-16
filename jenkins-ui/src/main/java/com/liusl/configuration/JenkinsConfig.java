package com.liusl.configuration;

import com.offbytwo.jenkins.JenkinsServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author liusl12
 * @date 2017/12/05
 */
@Configuration
public class JenkinsConfig {
    private static final String URL = "http://10.99.246.99:8080/jenkins";
    private static final String USERNAME = "microservice";
    private static final String PASSWORD = "abcd-1234";

    @Bean
    public JenkinsServer jenkinsServer() throws URISyntaxException {
        return new JenkinsServer(new URI(URL),USERNAME,PASSWORD);
    }
}
