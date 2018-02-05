package com.xue.util.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 全局控制
 * @author xueshun
 *
 */
/*@Configuration
public class CustomCorsConfiguration {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// 限制了路径和域名的访问
				registry.addMapping("/api/**").allowedOrigins("http://localhost:8081");
			}
		};
	}
}
*/