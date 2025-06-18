package com.SpringApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringApplication.entity.Transactions;
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, String> {

}
