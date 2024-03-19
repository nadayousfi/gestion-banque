package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modele.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
Optional<Account> findByIban(String iban);
Optional<Account> findByUserId(long id);

}
