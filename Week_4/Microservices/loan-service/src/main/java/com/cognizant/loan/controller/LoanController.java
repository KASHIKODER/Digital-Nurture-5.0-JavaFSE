package com.cognizant.loan.controller;

import com.cognizant.loan.model.Loan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = List.of(
            new Loan(1L, "Home Loan", 500000.0, 8.5, "Suyash Giri", "ACTIVE"),
            new Loan(2L, "Car Loan", 200000.0, 9.0, "Karan Sharma", "ACTIVE"),
            new Loan(3L, "Personal Loan", 50000.0, 12.0, "Priya Singh", "CLOSED")
        );
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Loan loan = new Loan(id, "Home Loan", 500000.0, 8.5, "Suyash Giri", "ACTIVE");
        return ResponseEntity.ok(loan);
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        return ResponseEntity.status(201).body(loan);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Loan Service is running on port 8084");
    }
}