package com.example.demo.mappeur;

import org.modelmapper.ModelMapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.modele.Utilisateur;

public class UtilisateurMappeur {
public static final ModelMapper modelMapper=new ModelMapper();
public static UserDTO convertToDTO (Utilisateur utilisateur) {
	return modelMapper.map(utilisateur, UserDTO.class);
}
public static Utilisateur convertToEntity(UserDTO userDTO) {
	return modelMapper.map(userDTO, Utilisateur.class);
}
}
