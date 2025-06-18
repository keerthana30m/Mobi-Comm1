package com.SpringApplication.service;

import com.SpringApplication.entity.Admin;
import com.SpringApplication.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByName(name);
        if (admin == null) {
            throw new UsernameNotFoundException("Admin not found with name: " + name);
        }
        return User.withUsername(admin.getName())
                .password(admin.getPassword())
                .roles(admin.getRole())
                .build();
    }
}