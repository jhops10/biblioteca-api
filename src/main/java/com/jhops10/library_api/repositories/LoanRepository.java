package com.jhops10.library_api.repositories;

import com.jhops10.library_api.entities.Book;
import com.jhops10.library_api.entities.Loan;
import com.jhops10.library_api.entities.LoanStatus;
import com.jhops10.library_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByUser(User user);
    List<Loan> findByBook(Book book);
    Optional<Loan> findByUserAndBookAndStatus(User user, Book book, LoanStatus status);
}
