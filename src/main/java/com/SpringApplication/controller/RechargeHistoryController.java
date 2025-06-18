package com.SpringApplication.controller;

import com.SpringApplication.dto.RechargeRequestDTO;
import com.SpringApplication.dto.RechargeResponseDTO;
import com.SpringApplication.entity.RechargeHistory;
import com.SpringApplication.service.RechargeHistoryService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/recharge")
public class RechargeHistoryController {
	@Autowired
    private RechargeHistoryService rechargeService;

    @PostMapping("/process")
    public RechargeResponseDTO processRecharge(@RequestBody RechargeRequestDTO request) {
        return rechargeService.processRecharge(request);
    }
    
    @GetMapping("/history")
    public ResponseEntity<List<RechargeHistory>> getRechargeHistory(@RequestParam Long userId) {
        List<RechargeHistory> history = rechargeService.getRechargeHistoryByUserId(userId);
        return ResponseEntity.ok(history);
    }
    
    @GetMapping("/expiring-soon")
    public ResponseEntity<List<RechargeHistory>> getExpiringSoon() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime threeDaysFromNow = now.plusDays(3);
        List<RechargeHistory> expiring = rechargeService.getRechargeHistoryExpiringBetween(now, threeDaysFromNow);
        return ResponseEntity.ok(expiring);
    }
    
}
