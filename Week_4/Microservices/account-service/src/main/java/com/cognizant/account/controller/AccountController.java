package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = List.of(
            new Account(1L, "Savings", 50000.0, "Suyash Giri"),
            new Account(2L, "Current", 100000.0, "Karan Sharma"),
            new Account(3L, "Savings", 25000.0, "Priya Singh")
        );
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = new Account(id, "Savings", 50000.0, "Suyash Giri");
        return ResponseEntity.ok(account);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.status(201).body(account);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Account Service is running on port 8083");
    }
}