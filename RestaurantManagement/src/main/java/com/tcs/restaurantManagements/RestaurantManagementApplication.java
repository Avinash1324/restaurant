package com.tcs.restaurantManagements;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tcs.restaurantManagements.model.User;
import com.tcs.restaurantManagements.repository.UserRepository;

@SpringBootApplication
public class RestaurantManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantManagementApplication.class, args);
	}
	  @Bean
	    CommandLineRunner run(UserRepository userRepository) {
	        return args -> {
	            if (userRepository.findByEmail("admin@system.com").isEmpty()) {
	                User admin = new User();
	                admin.setUsername("Admin");
	                admin.setEmail("admin@system.com");
	                admin.setPassword("admin123"); // ⚠ plain text
	                admin.setRole("ADMIN");
	                userRepository.save(admin);
	                System.out.println("✅ Admin user created: admin@system.com / admin123");
	            }
	        };
	    }

}
