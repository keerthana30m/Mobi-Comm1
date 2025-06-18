package com.SpringApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringApplication.entity.UserData;
@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long>{

}
