package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication //spring-boot 启动注解
@EnableEurekaServer // spring-cloud 服务注解
@MapperScan("com.fan.mapper")
public class RegisterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SpringApplicationBuilder(RegisterMain.class).web(true).run(args);
	}

}
