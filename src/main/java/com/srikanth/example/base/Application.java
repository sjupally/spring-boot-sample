package com.srikanth.example.base;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {
		"com.srikanth.example.configuration",		
		"com.srikanth.example.rest.controller"
		})
public class Application {

	public Application() {

	}

	public static void main(String[] args) {
		log.debug("ABC spring-boot-sample");
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		log.info("spring-boot-sample application name: {}", ctx.getApplicationName());
	}
}
