package com.drive.flashbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Cld2FlashBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cld2FlashBoxApplication.class, args);
	}

}
