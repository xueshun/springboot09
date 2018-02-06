package com.xue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

//启用缓存注解
@EnableCaching
@ServletComponentScan
@SpringBootApplication
public class Springboot09Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot09Application.class, args);
	}
}
