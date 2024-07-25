package com.eduardo.meeting.mappers;

import com.eduardo.meeting.DTOs.UserRequestDTO;
import com.eduardo.meeting.DTOs.UserResponseDTO;
import com.eduardo.meeting.entities.User;

public class UserMapper {
    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(user.getId(),
                user.getUsername(),
                user.getEmail());
    }

    public static User requestToEntity(UserRequestDTO userRequestDTO) {
        return new User(
                userRequestDTO.username(),
                userRequestDTO.password(),
                userRequestDTO.email()
        );
    }
}
