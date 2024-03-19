package com.example.demo.mappeur;

import org.modelmapper.ModelMapper;

import com.example.demo.dto.TransactionDTO;
import com.example.demo.modele.Transaction;

public class TransactionMappeur {
public static final ModelMapper modelMapper=new ModelMapper();
public static TransactionDTO convertToDTO(Transaction transaction) {
	return modelMapper.map(transaction, TransactionDTO.class);
}
public static Transaction convertTOEntity(TransactionDTO transactionDTO) {
	return modelMapper.map(transactionDTO, Transaction.class);
}
}
