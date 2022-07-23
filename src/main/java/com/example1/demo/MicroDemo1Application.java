package com.example1.demo;

import ch.qos.logback.core.joran.spi.ConsoleTarget;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroDemo1Application {
	public static void main(String[] args) {
		System.out.println("worked");
		SpringApplication.run(MicroDemo1Application.class, args);
	}
}
