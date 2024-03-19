package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdresseDTO;
import com.example.demo.service.AdresseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("adresse")
public class adresseController {
private final AdresseService service;
@PostMapping
public ResponseEntity<Long> save(@RequestBody AdresseDTO adresse){
	return ResponseEntity.ok(service.save(adresse));
}
@GetMapping("/{id}")
public ResponseEntity<AdresseDTO> findById(@PathVariable long id ){
	return ResponseEntity.ok(service.findById(id));
}
@GetMapping
public ResponseEntity<List<AdresseDTO>>findAll(){
	return ResponseEntity.ok(service.findAll());
}
@DeleteMapping("/{id}")
public void delete( @PathVariable  long id){
	service.delete(id);
}
}
