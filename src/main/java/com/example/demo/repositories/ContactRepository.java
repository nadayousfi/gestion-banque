package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modele.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
List<Contact> findAllByUserId(Long userId);
}
