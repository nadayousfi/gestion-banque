package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modele.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
List<Transaction> findAllByUserId(Long userId);

}
