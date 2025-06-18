package com.SpringApplication.controller;

import com.SpringApplication.entity.Users;
import com.SpringApplication.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/request-otp")
    public ResponseEntity<String> requestOtp(@RequestBody Map<String, String> request) {
        String mobileNumber = request.get("mobileNumber");
        if (mobileNumber == null) {
            return ResponseEntity.badRequest().body("Mobile number is required");
        }
        try {
            String message = usersService.requestOtp(mobileNumber);
            return ResponseEntity.ok(message);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody Map<String, String> request) {
        String mobileNumber = request.get("mobileNumber");
        String otp = request.get("otp");
        if (mobileNumber == null || otp == null) {
            return ResponseEntity.badRequest().body("Mobile number and OTP are required");
        }
        try {
            Map<String, Object> response = usersService.verifyOtp(mobileNumber, otp);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    
    
    @GetMapping("/users/all")
    @PreAuthorize("hasRole('ADMIN')") // Restrict to admin users only
    public ResponseEntity<List<Users>> getAllUsers() {
        try {
            List<Users> users = usersService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    
    @GetMapping("/me")
    public ResponseEntity<?> getUserDetails(@RequestParam String mobileNumber) {
        Users user = usersService.getUserByMobile(mobileNumber);
        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }
        return ResponseEntity.ok(user);
    }

}
