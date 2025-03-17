package com.jhops10.library_api.mappers;

import com.jhops10.library_api.dto.loan.CreateLoanDTO;
import com.jhops10.library_api.dto.loan.LoanDTO;
import com.jhops10.library_api.entities.Book;
import com.jhops10.library_api.entities.Loan;
import com.jhops10.library_api.entities.User;
import java.time.LocalDateTime;

public class LoanMapper {

    public static LoanDTO toLoanDTO(Loan loan) {
        return new LoanDTO(
                loan.getId(),
                loan.getBook().getId(),
                loan.getUser().getId(),
                loan.getLoanDate(),
                loan.getDueDate()
        );
    }

    public static Loan toLoan(CreateLoanDTO createLoanDTO, Book book, User user) {
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setUser(user);
        loan.setLoanDate(LocalDateTime.now());
        loan.setDueDate(createLoanDTO.getDueDate());
        return loan;
    }
}
