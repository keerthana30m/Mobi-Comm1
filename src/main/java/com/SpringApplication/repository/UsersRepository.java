package com.SpringApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringApplication.entity.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	Users findByMobileNumber(String mobileNumber);
	Users findByUserName(String userName);

}
