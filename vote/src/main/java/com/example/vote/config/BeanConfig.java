package com.example.vote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.vote.storage.SessionStorage;
import com.example.vote.storage.impl.SessionStorageImpl;

@Configuration
public class BeanConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	}
	
	@Bean
	public SessionStorage sessionStorage() {
		return new SessionStorageImpl();
	}

}
