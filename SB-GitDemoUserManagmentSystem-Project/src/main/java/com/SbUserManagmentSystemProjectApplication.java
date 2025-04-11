package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
@EnableCaching
public class SbUserManagmentSystemProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbUserManagmentSystemProjectApplication.class, args);
	}

}
