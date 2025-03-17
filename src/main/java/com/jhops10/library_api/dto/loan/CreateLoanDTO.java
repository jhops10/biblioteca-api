package com.jhops10.library_api.dto.loan;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateLoanDTO {

    @NotNull
    private Long bookId;

    @NotNull
    private Long userId;

    @Future
    private LocalDateTime dueDate;

    public CreateLoanDTO() {
    }

    public CreateLoanDTO(Long bookId, Long userId, LocalDateTime dueDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.dueDate = dueDate;
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

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
