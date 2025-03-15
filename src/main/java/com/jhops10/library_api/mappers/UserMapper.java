package com.jhops10.library_api.mappers;

import com.jhops10.library_api.dto.user.UserRequestDTO;
import com.jhops10.library_api.dto.user.UserResponseDTO;
import com.jhops10.library_api.entities.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setCreatedAt(request.getCreatedAt());
        return user;
    }

    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO userDTO = new UserResponseDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }
}
