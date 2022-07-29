package com.example1.demo;

import ch.qos.logback.core.joran.spi.ConsoleTarget;
import com.example1.demo.domain.AppUser;
import com.example1.demo.domain.Role;
import com.example1.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class MicroDemo1Application {
	public static void main(String[] args) {
		System.out.println("worked");
		SpringApplication.run(MicroDemo1Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
		    userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null,"chabrik1","abdellatif1","1278",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"chabrik2","abdellatif2","1278",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"chabrik3","abdellatif3","1278",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"chabrik4","abdellatif4","1278",new ArrayList<>()));

			userService.AddRoleToUser("abdellatif1","ROLE_USER");
			userService.AddRoleToUser("abdellatif2","ROLE_MANAGER");
			userService.AddRoleToUser("abdellatif3","ROLE_SUPER_ADMIN");
			userService.AddRoleToUser("abdellatif3","ROLE_USER");
			userService.AddRoleToUser("abdellatif1","ROLE_ADMIN");

		};
	}
}
