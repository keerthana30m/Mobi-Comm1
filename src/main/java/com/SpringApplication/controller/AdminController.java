package com.SpringApplication.controller;

import com.SpringApplication.entity.Admin;
import com.SpringApplication.service.AdminService;
import com.SpringApplication.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")

public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String password = request.get("password");

        if (name == null || password == null) {
            return ResponseEntity.status(400).body("Name and password are required");
        }

        Admin admin = adminService.authenticate(name, password);
        if (admin != null) {
            String jwt = jwtUtil.generateToken(admin);
            return ResponseEntity.ok(jwt);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

}