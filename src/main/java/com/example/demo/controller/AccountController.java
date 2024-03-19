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

import com.example.demo.dto.AccountDTO;
import com.example.demo.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
private final 	AccountService service;
@PostMapping
public ResponseEntity<Long> save(@RequestBody AccountDTO accountDTO){
	return ResponseEntity.ok(service.save(accountDTO));
}
@GetMapping
public ResponseEntity<List<AccountDTO>> findAll(){
	return ResponseEntity.ok(service.findAll());
}
@GetMapping("/id")
public ResponseEntity<AccountDTO> findById(@PathVariable long id){
	return ResponseEntity.ok(service.findById(id));
}
@DeleteMapping("/{id}")
public void delete(@PathVariable long id){
	 service.delete(id);
	
	
}
}
