package com.nitro.member.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//SpringCloud服务注册中心
@SpringBootApplication
@EnableEurekaServer
@RestController
@MapperScan("com.member")
@ComponentScan({"com.member.api.service.imp","com.common","com.member"})
public class AppMember {
	public static void main(String[] args) {
		SpringApplication.run(AppMember.class, args);
	}
	
}