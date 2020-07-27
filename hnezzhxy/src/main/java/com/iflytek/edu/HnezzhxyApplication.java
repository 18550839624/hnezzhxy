package com.iflytek.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.iflytek.edu.dao")
public class HnezzhxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HnezzhxyApplication.class, args);
	}

}
