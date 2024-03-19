package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modele.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {
List<Utilisateur> findAllByName(String name);
List<Utilisateur> findAllByNameContaining(String name);
List<Utilisateur> findAllByNameContainingIgnoringCase(String name);
List<Utilisateur> findAllByAccountIban(String iban);
Utilisateur findByNameContainingIgnoreCaseAndEmail(String name,String email);

}
