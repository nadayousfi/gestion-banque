package com.example.demo.modele;

import java.time.LocalDateTime;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties({"hibernateLazyInitialiser","handler"})
public class Utilisateur extends Identifiant{
	@NotNull
	@NotBlank(message = "le prenom ne doit pas etre null")
	@NotEmpty
private String name;
	@NotNull
	@NotBlank
	@NotEmpty
private String lastname;
	@NotNull
@NotBlank
@NotEmpty
@Email
private String email;
	@NotNull
	@NotBlank
	@NotEmpty
private String password;
	private LocalDateTime birthday;

private boolean active;
@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
private Adresse adresse;
@OneToMany(mappedBy = "user")
private List<Transaction> transaction;
@OneToMany(mappedBy ="user" )
private List<Contact> contact;
@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
private Account account;
@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
private Role role;

}
