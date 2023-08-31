package com.misim.greetinghire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GreetingHireApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingHireApplication.class, args);
	}

}
