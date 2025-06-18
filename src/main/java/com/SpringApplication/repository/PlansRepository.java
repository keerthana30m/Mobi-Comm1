package com.SpringApplication.repository;

import com.SpringApplication.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlansRepository extends JpaRepository<Plans, Long> {
    List<Plans> findByPlanCategoryAndPlanStatus(String planCategory, String planStatus);
}