package com.jhops10.library_api.services.loan;

import com.jhops10.library_api.entities.Loan;

import java.util.List;

public interface LoanService {
    Loan createLoan(Long userId, Long bookId);
    List<Loan> getLoansByUser(Long userId);
    void returnLoan(Long loanId);
}
