package com.web.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

//SpringCloud服务注册中心
@SpringBootApplication
@EnableEurekaServer
@ComponentScan({"com.web","com.common"})
@EnableFeignClients({"com.web"})
public class AppServer {
	public static void main(String[] args) {
		SpringApplication.run(AppServer.class, args);
	}
	
}