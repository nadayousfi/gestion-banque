package com.example.demo.mappeur;

import org.modelmapper.ModelMapper;

import com.example.demo.dto.ContactDTO;
import com.example.demo.modele.Contact;

public class ContactMappeur {
public static final ModelMapper modelMapper=new ModelMapper();
public static ContactDTO convertTODTO(Contact contact) {
	return modelMapper.map(contact, ContactDTO.class);
}
public static Contact convertToEntity(ContactDTO contactDTO) {
	return modelMapper.map(contactDTO, Contact.class);
}
}
