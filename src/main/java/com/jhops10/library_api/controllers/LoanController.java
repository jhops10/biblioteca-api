package com.jhops10.library_api.controllers;

import com.jhops10.library_api.entities.Loan;
import com.jhops10.library_api.services.loan.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/{userId}/{bookId}")
    public ResponseEntity<Loan> createLoan(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {
        Loan loan = loanService.createLoan(userId, bookId);
        return ResponseEntity.status(HttpStatus.CREATED).body(loan);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Loan>> getLoansByUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(loanService.getLoansByUser(userId));
    }

    @PutMapping("/{loanId}/return")
    public ResponseEntity<Void> returnLoan(@PathVariable("loanId") Long loanId) {
        loanService.returnLoan(loanId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
