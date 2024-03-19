package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AdresseDTO;
import com.example.demo.exception.ObjectValidator;
import com.example.demo.mappeur.AdresseMappeur;
import com.example.demo.modele.Adresse;
import com.example.demo.repositories.AdresseRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor

public class AdresseServiceImpl implements AdresseService {
	private final AdresseRepository repository;
	private ObjectValidator<AdresseDTO> validator;
	

	@Override
	public long save(AdresseDTO dto) {
		validator.validate(dto);
		Adresse adresse=AdresseMappeur.convertToEntity(dto);
		return repository.save(adresse).getId();
	}

	@Override
	public List<AdresseDTO> findAll() {
		return repository.findAll()
		.stream()
		.map(AdresseMappeur::convertToDTO)
		.collect(Collectors.toList());
	}

	@Override
	public AdresseDTO findById(long id) {
		return repository.findById(id)
		.map(AdresseMappeur::convertToDTO)
		.orElseThrow(() ->new EntityNotFoundException("no adrresse found with the id"+id));
	}

	@Override
	public void delete(long id) {	
		repository.deleteById(id);
	}

}
