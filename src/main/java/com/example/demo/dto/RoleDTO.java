package com.example.demo.dto;


import com.example.demo.modele.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleDTO {
	 String name;

	 Utilisateur user;
}
