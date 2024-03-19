package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDTO;
import com.example.demo.exception.ObjectValidator;
import com.example.demo.exception.OperationNonPermittedException;
import com.example.demo.mappeur.AccountMappeur;
import com.example.demo.modele.Account;
import com.example.demo.repositories.AccountRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AccountServiceImlp implements AccountService {
	private final AccountRepository repository;
	private final ObjectValidator<AccountDTO> validator;
	
	@Override
	public long save(AccountDTO dto) {
		if(dto.getId()!=null) {
			throw new OperationNonPermittedException("account cannot br updated","save account","account","update not permitted");
		}
		validator.validate(dto);
		Account account=AccountMappeur.convertToEntity(dto);
		boolean userhasAlreadyAccount=repository.findByUserId(account.getUser().getId()).isPresent();
		if(userhasAlreadyAccount) {
			throw new OperationNonPermittedException("the selected user have already account","create account","account service","account creation");
		}
		account.setIban(generateRandomIban());
		return repository.save(account).getId();
	}

	@Override
	public List<AccountDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(AccountMappeur::convertToDTO)
				.collect(Collectors.toList());
				
	}

	@Override
	public AccountDTO findById(long id) {
		return repository.findById(id)
				.map(AccountMappeur::convertToDTO)
				.orElseThrow(()->new EntityNotFoundException("no account was found with the id"+id));

	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}
private String generateRandomIban() {
	String iban=Iban.random(CountryCode.DE).toFormattedString();
	Boolean ibanExist= repository.findByIban(iban).isPresent();
	if(ibanExist) {
		generateRandomIban();
		}
	return iban;
	
}
}
