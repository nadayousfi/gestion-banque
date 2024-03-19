package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TransactionDTO;

public interface TransactionService extends AbstractService<TransactionDTO> {
	  List<TransactionDTO> findAllByUserId(Long   userId);

}
