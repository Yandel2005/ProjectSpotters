package com.projectspotters;

import com.projectspotters.entity.User;
import com.projectspotters.repository.UserRepository; // <--- Matches the package above
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectSpottersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSpottersApplication.class, args);
    }

    //Execute this method on startup
    @Bean
    public CommandLineRunner testDataBase(UserRepository userRepository) {
        return args -> {
            System.out.println("\n--- TESTING DATABASE CONNECTIVITY & REPOSITORY ---");

            User newUser = new User("testuser", "test@example.com", "hashed_pass_123");
            User savedUser = userRepository.save(newUser);
            System.out.println("Saved User ID: " + savedUser.getUserId());

            userRepository.findByUsername("testuser").ifPresent(user -> {
                System.out.println("Retrieved User from DB: " + user.getUsername());
                System.out.println("Retrieved Email: " + user.getEmail());
                System.out.println("Created At Timestamp: " + user.getCreatedAt());
            });

            System.out.println("--------------------------------------------------\n");
        };
    }
}