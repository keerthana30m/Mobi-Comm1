package com.SpringApplication.service;

import com.SpringApplication.entity.Admin;
import com.SpringApplication.entity.Users;
import com.SpringApplication.repository.AdminRepository;
import com.SpringApplication.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository; // Repository for admin users

    @Autowired
    private UsersRepository usersRepository; // Repository for regular users

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Attempt to load an admin first (assuming Admin entity has getName() and getPassword())
        Admin admin = adminRepository.findByName(username);
        if (admin != null) {
            return new org.springframework.security.core.userdetails.User(
                admin.getName(), 
                admin.getPassword(), 
                Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            );
        }
        
        // Otherwise, try to load a regular user (assuming Users entity has getUserName())
        Users user = usersRepository.findByUserName(username);
        if (user != null) {
            // Here the password might not be used if you rely on JWT; if it is needed, ensure it's stored correctly.
            return new org.springframework.security.core.userdetails.User(
                user.getUserName(), 
                "", // or user.getPassword() if applicable
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            );
        }
        
        throw new UsernameNotFoundException("User not found with name: " + username);
    }
}
