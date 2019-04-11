package com.lh.ekbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lh.ekbase.mapper")
public class EKBaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(EKBaseApplication.class, args);
	}
}
