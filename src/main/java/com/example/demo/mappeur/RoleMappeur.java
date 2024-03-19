package com.example.demo.mappeur;

import org.modelmapper.ModelMapper;

import com.example.demo.dto.RoleDTO;
import com.example.demo.modele.Role;

public class RoleMappeur {
public static final ModelMapper modelMapper=new ModelMapper();
public static RoleDTO convertToDTO (Role role) {
	return modelMapper.map(role, RoleDTO.class);
}
public static Role convertToEntity(RoleDTO roleDTO) {
	return modelMapper.map(roleDTO, Role.class);
}
}
