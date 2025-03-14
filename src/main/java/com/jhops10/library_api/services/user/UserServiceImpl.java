package com.jhops10.library_api.services.user;

import com.jhops10.library_api.entities.User;
import com.jhops10.library_api.exceptions.EmailAlreadyExistsException;
import com.jhops10.library_api.exceptions.UserNotFoundException;
import com.jhops10.library_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário com o id " + id + " não encontrado."));
    }

    @Override
    public User save(User user) {
        userRepository.findByEmail(user.getEmail()).ifPresent(u -> {
            throw new EmailAlreadyExistsException("Já existe um usuário cadastrado com este e-mail.");
        });
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuário com o email " + email + " não encontrado."));
    }
}
