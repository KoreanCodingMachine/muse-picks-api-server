package com.kjh.musepicks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MusepicksApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusepicksApplication.class, args);
	}

}
