package com.jhops10.library_api.services.loan;

import com.jhops10.library_api.entities.Book;
import com.jhops10.library_api.entities.Loan;
import com.jhops10.library_api.entities.LoanStatus;
import com.jhops10.library_api.entities.User;
import com.jhops10.library_api.exceptions.BookNotFoundException;
import com.jhops10.library_api.exceptions.LoanNotFoundException;
import com.jhops10.library_api.exceptions.UserNotFoundException;
import com.jhops10.library_api.repositories.BookRepository;
import com.jhops10.library_api.repositories.LoanRepository;
import com.jhops10.library_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public LoanServiceImpl(LoanRepository loanRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Loan createLoan(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Livro não encontrado"));

        Optional<Loan> existingLoan = loanRepository.findByUserAndBookAndStatus(user, book, LoanStatus.ACTIVE);
        if (existingLoan.isPresent()) {
            throw new IllegalStateException("O usuário já pegou este livro emprestado");
        }

        Loan loan = new Loan(user, book, LocalDateTime.now());
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getLoansByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));

        return loanRepository.findByUser(user);
    }

    @Override
    public void returnLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException("Reserva não encontrada"));

        if(loan.getStatus() != LoanStatus.ACTIVE) {
            throw new IllegalStateException("A reserva já foi finalizada");
        }

        loan.returnLoan();
        loanRepository.save(loan);
    }
}
