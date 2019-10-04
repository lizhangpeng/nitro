package com.messages.eurekaserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
@EnableEurekaServer
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
@ComponentScan({"com.messages"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
