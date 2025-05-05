package com.workintech.s18d2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.workintech.s18d2.entity")
@EnableJpaRepositories("com.workintech.s18d2.repository")
public class S18d2Application {

	public static void main(String[] args) {
		SpringApplication.run(S18d2Application.class, args);
	}

}
