package org.codecritique.javajokes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JavaJokesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaJokesApplication.class, args);
	}

}
