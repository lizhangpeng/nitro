package com.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


//SpringCloud服务注册中心
@SpringBootApplication
@EnableEurekaServer
@RestController
@MapperScan("com.goods.dao")
@ComponentScan({"com.goods"})
public class AppGoodsEureka {
	public static void main(String[] args) {
		SpringApplication.run(AppGoodsEureka.class, args);
	}
	
}