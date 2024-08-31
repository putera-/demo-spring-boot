package com.example.putera_demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class PuteraDemoApplication {

	/**
  * The main entry point for the Putera Demo application.
  * This method sets the default server port to 8081 and runs the Spring Boot application.
  */
 public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PuteraDemoApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
		app.run(args);
	}
}
