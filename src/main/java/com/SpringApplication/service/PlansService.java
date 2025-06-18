package com.SpringApplication.service;

import com.SpringApplication.entity.Plans;
import com.SpringApplication.repository.PlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlansService {

    @Autowired
    private PlansRepository plansRepository;
    

    public List<Plans> getAllPlans() {
        return plansRepository.findAll();
    }
    

    public Plans savePlan(Plans plan) {
        return plansRepository.save(plan);
    }
    public Plans getPlanById(Long planId) {
        return plansRepository.findById(planId).orElse(null);
    }

    public List<Plans> getPlansByCategory(String category) {
        return plansRepository.findByPlanCategoryAndPlanStatus(category, "Active");
    }
}