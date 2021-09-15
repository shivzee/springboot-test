package com.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.*")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.test.repository")
@EntityScan("com.test.entity")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
