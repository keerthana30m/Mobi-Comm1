package com.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordHasher implements CommandLineRunner {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        String password = "ADMIN1@12345";
//        String hashedPassword = passwordEncoder.encode(password);
//        System.out.println("Hashed Password for ADMIN1@12345: " + hashedPassword);
    }
}