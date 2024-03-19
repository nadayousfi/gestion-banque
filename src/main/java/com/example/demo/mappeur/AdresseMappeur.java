package com.example.demo.mappeur;

import org.modelmapper.ModelMapper;

import com.example.demo.dto.AdresseDTO;
import com.example.demo.modele.Adresse;

public class AdresseMappeur {
public static final ModelMapper modelMapper=new ModelMapper();
public static AdresseDTO convertToDTO(Adresse adresse) {
	return modelMapper.map(adresse, AdresseDTO.class);
}
public static Adresse convertToEntity(AdresseDTO adresseDTO) {
	return modelMapper.map(adresseDTO, Adresse.class);
}
}
