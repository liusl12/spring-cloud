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
    private static final String URL = "http://10.122.23.149:9082";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123#";

    @Bean
    public JenkinsServer jenkinsServer() throws URISyntaxException {
        return new JenkinsServer(new URI(URL),USERNAME,PASSWORD);
    }
}
