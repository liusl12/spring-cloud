package com.liusl;

import com.liusl.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class MicroserviceZuulApplication {
	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
//	@Bean
//	public PatternServiceRouteMapper patternServiceRouteMapper(){
//		return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)",
//				"${version}/${name}");
//	}
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceZuulApplication.class, args);
	}
}
