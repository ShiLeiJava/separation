package com.leo.separation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
//@EnableTransactionManagement(order = 10) //开启事务，并设置order值，默认是Integer的最大值
@ComponentScan(basePackages={"com.leo.separation"})
@SpringBootApplication
public class SeparationApplication extends SpringBootServletInitializer  {



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SeparationApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SeparationApplication.class, args);
	}
}
