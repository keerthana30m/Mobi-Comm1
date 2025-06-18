package com.SpringApplication.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringApplication.dto.RechargeRequestDTO;
import com.SpringApplication.dto.RechargeResponseDTO;
import com.SpringApplication.entity.Plans;
import com.SpringApplication.entity.RechargeHistory;
import com.SpringApplication.entity.Transactions;
import com.SpringApplication.entity.Users;
import com.SpringApplication.repository.PlansRepository;
import com.SpringApplication.repository.RechargeHistoryRepository;
import com.SpringApplication.repository.TransactionsRepository;
import com.SpringApplication.repository.UsersRepository;

@Service
public class RechargeHistoryService {
	

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PlansRepository plansRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private RechargeHistoryRepository rechargeHistoryRepository;

    @Transactional
    public RechargeResponseDTO processRecharge(RechargeRequestDTO request) {
        Users user = usersRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Plans plan = plansRepository.findById(request.getPlanId())
                .orElseThrow(() -> new RuntimeException("Plan not found"));

        // Generate Unique Transaction ID
        String transactionId = UUID.randomUUID().toString();

        // Create a new transaction record
        Transactions transaction = new Transactions();
        transaction.setTransactionId(transactionId);
        transaction.setUser(user);
        transaction.setPlan(plan);
        transaction.setPaymentStatus("SUCCESS");
        transaction.setPaymentMethod(request.getPaymentMethod());
        transaction.setPaymentDate(LocalDateTime.now());
        transactionsRepository.save(transaction);

        // Create a new recharge history record
        RechargeHistory rechargeHistory = new RechargeHistory();
        rechargeHistory.setUser(user);
        rechargeHistory.setPlan(plan);
        rechargeHistory.setTransaction(transaction);
        rechargeHistory.setRechargeDate(LocalDateTime.now());
        rechargeHistory.setRechargeEnd(LocalDateTime.now().plusDays(plan.getValidityDays())); // Assuming validityDays in plan
        rechargeHistory.setAmountPaid(plan.getPlanPrice());
        rechargeHistory.setPaymentMethod(request.getPaymentMethod());
        rechargeHistoryRepository.save(rechargeHistory);

        // Prepare Response
        RechargeResponseDTO response = new RechargeResponseDTO();
        response.setUserId(user.getUserId());
        response.setPlanId(plan.getPlanId());
        response.setTransactionId(transactionId);
        response.setStartDate(rechargeHistory.getRechargeDate());
        response.setExpiryDate(rechargeHistory.getRechargeEnd());
        response.setAmountPaid(rechargeHistory.getAmountPaid());
        response.setPaymentMethod(rechargeHistory.getPaymentMethod());

        return response;
    }
    
    public List<RechargeHistory> getRechargeHistoryByUserId(Long userId) {
        return rechargeHistoryRepository.findByUser_UserId(userId);
    }
    
   
    public List<RechargeHistory> getRechargeHistoryByUserId1(Long userId) {
        return rechargeHistoryRepository.findByUser_UserId(userId);
    }

    public List<RechargeHistory> getRechargeHistoryExpiringBetween(LocalDateTime start, LocalDateTime end) {
        // Log the input range
        System.out.println("Fetching records between " + start + " and " + end);

        // Fetch records using the repository query
        List<RechargeHistory> allExpiring = rechargeHistoryRepository.findByRechargeEndBetween(start, end);
        System.out.println("Found " + allExpiring.size() + " expiring records:");
        allExpiring.forEach(rh -> System.out.println("Record ID: " + rh.getHistoryId() + 
                                                     ", User ID: " + rh.getUser().getUserId() + 
                                                     ", Recharge End: " + rh.getRechargeEnd() + 
                                                     ", Recharge Date: " + rh.getRechargeDate()));

        // Filter for the latest recharge per user
        List<RechargeHistory> latestExpiring = allExpiring.stream()
            .collect(Collectors.groupingBy(
                rh -> rh.getUser().getUserId(),
                Collectors.maxBy(Comparator.comparing(RechargeHistory::getRechargeDate))
            ))
            .values()
            .stream()
            .map(Optional::get)
            .collect(Collectors.toList());
        System.out.println("Filtered to " + latestExpiring.size() + " latest records:");
        latestExpiring.forEach(rh -> System.out.println("Latest Record ID: " + rh.getHistoryId() + 
                                                        ", User ID: " + rh.getUser().getUserId() + 
                                                        ", Recharge End: " + rh.getRechargeEnd()));

        return latestExpiring;
    }
}
 

