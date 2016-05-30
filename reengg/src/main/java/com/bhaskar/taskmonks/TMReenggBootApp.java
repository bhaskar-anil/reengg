package com.bhaskar.taskmonks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan("com.bhaskar.taskmonks")
public class TMReenggBootApp {

	public static void main(String[] args) {
		SpringApplication.run(TMReenggBootApp.class, args);

	}

}
