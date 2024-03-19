package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TransactionDTO;
import com.example.demo.exception.ObjectValidator;
import com.example.demo.mappeur.TransactionMappeur;
import com.example.demo.modele.Transaction;
import com.example.demo.modele.TransactionType;
import com.example.demo.repositories.TransactionRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
	private final TransactionRepository repository;
	private final ObjectValidator<TransactionDTO> validator;
	
	@Override
	public long save(TransactionDTO dto) {
		validator.validate(dto);
		Transaction transaction=TransactionMappeur.convertTOEntity(dto);
		BigDecimal transactionMultiplier=BigDecimal.valueOf(getTransactionMultiplier(transaction.getType()));
		BigDecimal amount =transaction.getAmount().multiply(transactionMultiplier);
		transaction.setAmount(amount);
		return repository.save(transaction).getId();
	}

	private long getTransactionMultiplier(TransactionType type) {
	    return TransactionType.TRANSFERT == type ? -1 : 1;

	}

	@Override
	public List<TransactionDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(TransactionMappeur::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public TransactionDTO findById(long id) {
		return repository.findById(id)
				.map(TransactionMappeur::convertToDTO)
				.orElseThrow(() ->new EntityNotFoundException("no transaction was found with the id"+id));
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
		
	}
	private int transactionType(TransactionType type) {
		return TransactionType.TRANSFERT==type? -1 :1;
	}

	@Override
	public List<TransactionDTO> findAllByUserId(Long userId) {
		return repository.findAllByUserId(userId)
				.stream()
				.map(TransactionMappeur::convertToDTO)
				.collect(Collectors.toList());
	}

	

	

}
