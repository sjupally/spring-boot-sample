package com.srikanth.example.configuration;

import javax.servlet.Servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	@Bean(name="hystrix.stream")
	public Servlet hystrixMetricsStreamServlet() {
		return new HystrixMetricsStreamServlet();
	}
}
