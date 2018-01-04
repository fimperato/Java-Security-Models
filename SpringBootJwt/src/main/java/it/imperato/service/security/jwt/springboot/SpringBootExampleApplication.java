package it.imperato.service.security.jwt.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot Application
 * 
 * @author Francesco
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"it.imperato.service.security"})
public class SpringBootExampleApplication {

	public static void main(String[] args) {  
		
		SpringApplication.run(SpringBootExampleApplication.class, args);
		
	}
}
