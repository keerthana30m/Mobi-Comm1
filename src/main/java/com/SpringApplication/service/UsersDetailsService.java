package com.SpringApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringApplication.entity.Users;
import com.SpringApplication.repository.UsersRepository;

@Service("userDetailsService")
public class UsersDetailsService implements UserDetailsService{
 
	@Autowired
    private UsersRepository usersRepository;
	
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with name: " + username);
        }
        // Create a Spring Security User (or a custom UserDetails object)
        return User.withUsername(user.getUserName())
                .password("") // As you're using JWT, password might not be needed here
                .roles("USER")
                .build();
    }
}
