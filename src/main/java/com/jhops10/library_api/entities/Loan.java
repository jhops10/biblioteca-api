package com.jhops10.library_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Book book;

    private LocalDateTime loanDate = LocalDateTime.now();
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    public Loan() {
    }

    public Loan(Long id, User user, Book book, LocalDateTime loanDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.loanDate = (loanDate != null) ? loanDate : LocalDateTime.now();
        this.dueDate = loanDate.plusDays(3);
        this.status = LoanStatus.ACTIVE;
    }

    public Loan(User user, Book book, LocalDateTime now) {
        this.user = user;
        this.book = book;
        this.loanDate = now;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull User getUser() {
        return user;
    }

    public void setUser(@NotNull User user) {
        this.user = user;
    }

    public @NotNull Book getBook() {
        return book;
    }

    public void setBook(@NotNull Book book) {
        this.book = book;
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


    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public void returnLoan() {
        if (this.status == LoanStatus.ACTIVE) {
            this.status = LoanStatus.EXPIRED;
        }
    }
}
