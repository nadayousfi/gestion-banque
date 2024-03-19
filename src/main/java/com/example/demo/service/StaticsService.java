package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.dto.TransactionSumDetails;

public interface StaticsService {
List<TransactionSumDetails> findsumTransactionSumDetails(LocalDate startdate,LocalDate endDate,long id);
BigDecimal getAccounBalance(long id);
BigDecimal hightTransfer(long id);
BigDecimal highestDeposit(long id);

}
