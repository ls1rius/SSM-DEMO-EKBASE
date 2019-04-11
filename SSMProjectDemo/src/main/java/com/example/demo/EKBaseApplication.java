package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class EKBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EKBaseApplication.class, args);
	}
}
