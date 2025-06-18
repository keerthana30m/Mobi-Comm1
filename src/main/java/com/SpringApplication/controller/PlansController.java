package com.SpringApplication.controller;

import com.SpringApplication.entity.Plans;
import com.SpringApplication.service.PlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/plans")
public class PlansController {

    @Autowired
    private PlansService plansService;
     
 
    @GetMapping("/all")
    public List<Plans> getAllPlans() {
        return plansService.getAllPlans();
    }

    @PostMapping
    public ResponseEntity<Plans> addPlan(@RequestBody Plans plan) {
        Plans savedPlan = plansService.savePlan(plan);
        return new ResponseEntity<>(savedPlan, HttpStatus.CREATED);
    }
    
    @PutMapping("/{planId}")
    public ResponseEntity<Plans> updatePlan(@PathVariable Long planId, @RequestBody Plans plan) {
        Plans existingPlan = plansService.getPlanById(planId);
        if (existingPlan == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        plan.setPlanId(planId); // Ensure the ID remains the same
        Plans updatedPlan = plansService.savePlan(plan);
        return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
    }

    @GetMapping("/true5g")
    public List<Plans> getTrue5GPlans() {
        return plansService.getPlansByCategory("True 5G");
    }

    @GetMapping("/validity")
    public List<Plans> getValidityPlans() {
        return plansService.getPlansByCategory("Validity");
    }

    @GetMapping("/data")
    public List<Plans> getDataPlans() {
        return plansService.getPlansByCategory("Data");
    }

    @GetMapping("/unlimited")
    public List<Plans> getUnlimitedPlans() {
        return plansService.getPlansByCategory("Unlimited");
    }

    @GetMapping("/entertainment")
    public List<Plans> getEntertainmentPlans() {
        return plansService.getPlansByCategory("Entertainment");
    }

    @GetMapping("/annual")
    public List<Plans> getAnnualPlans() {
        return plansService.getPlansByCategory("Annual");
    }

    @GetMapping("/topup")
    public List<Plans> getTopUpPlans() {
        return plansService.getPlansByCategory("Top-up");
    }
    
}