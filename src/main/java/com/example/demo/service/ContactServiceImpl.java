package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ContactDTO;
import com.example.demo.exception.ObjectValidator;
import com.example.demo.mappeur.ContactMappeur;
import com.example.demo.modele.Contact;
import com.example.demo.repositories.ContactRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
	private final ContactRepository repository;
	private final ObjectValidator<ContactDTO> validator;
	@Override
	public long save(ContactDTO dto) {
		validator.validate(dto);
		Contact contact=ContactMappeur.convertToEntity(dto);
		
		return repository.save(contact).getId();
	}

	@Override
	public List<ContactDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(ContactMappeur::convertTODTO)
				.collect(Collectors.toList());
	}

	@Override
	public ContactDTO findById(long id) {
		return repository.findById(id)
				.map(ContactMappeur::convertTODTO)
				.orElseThrow(()->new EntityNotFoundException("no contact was found with the id"+id));
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<ContactDTO> findAllByUserId(Long userId) {
		return repository.findAllByUserId(userId)
				.stream()
				.map(ContactMappeur::convertTODTO)
				.collect(Collectors.toList());
	}

}
