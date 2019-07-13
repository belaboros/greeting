package com.bb.mstest1.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationProperties(prefix="greetapp")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
