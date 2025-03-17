package com.jhops10.library_api.dto.loan;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LoanDTO {

    private Long id;
    private Long bookId;
    private Long userId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;

    public LoanDTO() {
    }

    public LoanDTO(Long id, Long bookId, Long userId, LocalDateTime loanDate, LocalDateTime dueDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
