package com.jhops10.library_api.controllers;

import com.jhops10.library_api.dto.loan.CreateLoanDTO;
import com.jhops10.library_api.dto.loan.LoanDTO;
import com.jhops10.library_api.entities.Loan;
import com.jhops10.library_api.mappers.LoanMapper;
import com.jhops10.library_api.services.loan.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/{userId}/{bookId}")
    public ResponseEntity<LoanDTO> createLoan(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {
        Loan loan = loanService.createLoan(userId, bookId);
        LoanDTO loanDTO = LoanMapper.toLoanDTO(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(loanDTO);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoanDTO>> getLoansByUser(@PathVariable("userId") Long userId) {
        List<Loan> loans = loanService.getLoansByUser(userId);
        List<LoanDTO> loanDTOs = loans.stream()
                .map(LoanMapper::toLoanDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(loanDTOs);
    }

    @PutMapping("/{loanId}/return")
    public ResponseEntity<Void> returnLoan(@PathVariable("loanId") Long loanId) {
        loanService.returnLoan(loanId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
