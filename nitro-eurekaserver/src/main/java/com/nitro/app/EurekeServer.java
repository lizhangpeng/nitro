package com.nitro.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//SpringCloud服务注册中心
@SpringBootApplication
@EnableEurekaServer
public class EurekeServer {

	public static void main(String[] args) {
	    SpringApplication.run(EurekeServer.class, args);
	}
}