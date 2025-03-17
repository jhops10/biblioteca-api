package com.jhops10.library_api.dto.user;

import com.jhops10.library_api.dto.loan.LoanDTO;
import com.jhops10.library_api.entities.UserRole;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole role;
    private LocalDateTime createdAt = LocalDateTime.now();
    private List<LoanDTO> loans;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String name, String email, String password, UserRole role, LocalDateTime createdAt, List<LoanDTO> loans) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
        this.loans = loans.stream()
                .map(loan -> new LoanDTO(loan.getId(), loan.getBookId(), loan.getUserId(), loan.getLoanDate(), loan.getDueDate()))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<LoanDTO> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanDTO> loans) {
        this.loans = loans;
    }
}
