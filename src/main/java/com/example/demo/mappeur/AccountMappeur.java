package com.example.demo.mappeur;

import org.modelmapper.ModelMapper;

import com.example.demo.dto.AccountDTO;
import com.example.demo.modele.Account;

public class AccountMappeur {
private static final ModelMapper modelMappeur=new ModelMapper();
public static AccountDTO convertToDTO(Account account) {
	return modelMappeur.map(account, AccountDTO.class);
}
public static Account convertToEntity(AccountDTO acountDTO) {
	return modelMappeur.map(acountDTO, Account.class);
}
}
