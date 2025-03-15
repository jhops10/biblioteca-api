package com.jhops10.library_api.services.user;

import com.jhops10.library_api.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
    User save(User user);
    User findByEmail(String email);
    void deleteById(Long id);
}
