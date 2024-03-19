package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modele.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

}
