package com.SpringApplication.repository;

import com.SpringApplication.entity.RechargeHistory;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RechargeHistoryRepository extends JpaRepository<RechargeHistory, Long> {
	List<RechargeHistory> findByUser_UserId(Long userId);

	    @Query("SELECT rh FROM RechargeHistory rh WHERE rh.rechargeEnd BETWEEN :start AND :end")
	    List<RechargeHistory> findByRechargeEndBetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
	}
	

