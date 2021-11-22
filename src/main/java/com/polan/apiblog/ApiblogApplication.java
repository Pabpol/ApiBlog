package com.polan.apiblog;

import java.util.ArrayList;

import com.polan.apiblog.model.AppUser;
import com.polan.apiblog.model.Role;
import com.polan.apiblog.service.AppUserService;
import com.polan.apiblog.service.Impl.AppUserServiceImpl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ApiblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiblogApplication.class, args);

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
/* 	@Bean
	CommandLineRunner run(AppUserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveAppUser(new AppUser(null, "pp@mail.com", "123", null, new ArrayList<>()));
			userService.saveAppUser(new AppUser(null, "vv@mail.com", "123", null, new ArrayList<>()));
			userService.saveAppUser(new AppUser(null, "nn@mail.com", "123", null, new ArrayList<>()));
			userService.saveAppUser(new AppUser(null, "ii@mail.com", "123", null, new ArrayList<>()));

			userService.addRoleToUser("vv@mail.com", "ROLE_USER");
			userService.addRoleToUser("ii@mail.com", "ROLE_MANAGER");
			userService.addRoleToUser("nn@mail.com", "ROLE_ADMIN");
			userService.addRoleToUser("pp@mail.com", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("pp@mail.com", "ROLE_ADMIN");
			userService.addRoleToUser("pp@mail.com", "ROLE_USER");
		};
	} */
	

}
