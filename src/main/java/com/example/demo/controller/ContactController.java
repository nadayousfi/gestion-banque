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

import com.example.demo.dto.ContactDTO;
import com.example.demo.service.ContactService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/contact")
@RestController
@RequiredArgsConstructor
public class ContactController {
private final ContactService service;
@PostMapping
public ResponseEntity<Long>save(@RequestBody ContactDTO contactDTO){
	return ResponseEntity.ok(service.save(contactDTO));
}
@GetMapping
public ResponseEntity<List<ContactDTO>> findAll(){
	return ResponseEntity.ok(service.findAll());
}
@GetMapping("/{id}")
public ResponseEntity<List<ContactDTO>> finsById(@PathVariable long id){
	return ResponseEntity.ok(service.findAllByUserId(id));
}
@DeleteMapping("/{id}")
public void delete(@PathVariable long id ){
	 service.delete(id);
}
}
