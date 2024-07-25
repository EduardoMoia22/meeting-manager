package com.eduardo.meeting.services;

import com.eduardo.meeting.DTOs.UserRequestDTO;
import com.eduardo.meeting.entities.User;
import com.eduardo.meeting.mappers.UserMapper;
import com.eduardo.meeting.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserRequestDTO user) {
        return this.userRepository.save(UserMapper.requestToEntity(user));
    }

    public Optional<User> findUserById(UUID id) {
        return this.userRepository.findById(id);
    }
}
