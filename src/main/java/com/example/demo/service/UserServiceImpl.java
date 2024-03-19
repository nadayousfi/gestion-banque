package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.exception.ObjectValidator;
import com.example.demo.mappeur.UtilisateurMappeur;
import com.example.demo.modele.Account;
import com.example.demo.modele.Utilisateur;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	 
	private  final UserRepository repository;
	private final AccountService accountService;
	private final ObjectValidator<UserDTO> validator;
	@Override
	public long save(UserDTO dto) {
		validator.validate(dto);
		Utilisateur user=UtilisateurMappeur.convertToEntity(dto);
		return repository.save(user).getId();
	}

	@Override
	public List<UserDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(UtilisateurMappeur::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public UserDTO findById(long id) {
	    return repository.findById(id)
	            .map(UtilisateurMappeur::convertToDTO)
	            .orElseThrow(() -> new EntityNotFoundException("no user was found with the provided id:" + id));
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public Long validateAccount(Long id) {
		Utilisateur user=repository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("no user was found for user account"+id));
		user.setActive(true);
		UserDTO userDTO=UtilisateurMappeur.convertToDTO(user);
		
		AccountDTO account=new AccountDTO();
				account.setUser(userDTO);
		accountService.save(account);
		repository.save(user);
		
		return user.getId();
	}

	@Override
	public long invalidateAccount(Long id) {
		Utilisateur user=repository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("no user was found for user account"+id));
		user.setActive(false);
		repository.save(user);
		return user.getId();
	}

}
