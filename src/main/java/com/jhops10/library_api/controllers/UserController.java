package com.jhops10.library_api.controllers;

import com.jhops10.library_api.dto.user.UserRequestDTO;
import com.jhops10.library_api.dto.user.UserResponseDTO;
import com.jhops10.library_api.entities.User;
import com.jhops10.library_api.mappers.UserMapper;
import com.jhops10.library_api.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<User> userList = userService.findAll();
        List<UserResponseDTO> usersResponseDTO = userList.stream().map(UserMapper::toDTO).toList();
        return ResponseEntity.ok(usersResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        UserResponseDTO response = UserMapper.toDTO(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> findByEmail(@PathVariable("email") String email) {
        User user = userService.findByEmail(email);
        UserResponseDTO response = UserMapper.toDTO(user);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        User user = UserMapper.toEntity(userRequestDTO);
        User savedUser = userService.save(user);
        UserResponseDTO response = UserMapper.toDTO(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
