package com.example.authservice;

import com.example.authservice.domain.AppUser;
import com.example.authservice.domain.Role;
import com.example.authservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "Marko Markic", "marko", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Nikola Tesla", "nikola", "abcd", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Majstor Fantac", "fantac", "qwer", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Bruce Wayne", "bruce", "xyz", new ArrayList<>()));

			userService.addRoleToAppUser("marko", "ROLE_USER");
			userService.addRoleToAppUser("fantac", "ROLE_USER");
			userService.addRoleToAppUser("nikola", "ROLE_ADMIN");
			userService.addRoleToAppUser("bruce", "ROLE_ADMIN");
			userService.addRoleToAppUser("bruce", "ROLE_SUPER_ADMIN");

		};
	}

}
