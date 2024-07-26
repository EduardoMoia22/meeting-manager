package com.eduardo.meeting.services;

import com.eduardo.meeting.DTOs.UserRequestDTO;
import com.eduardo.meeting.entities.User;
import com.eduardo.meeting.mappers.UserMapper;
import com.eduardo.meeting.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public User findUserById(UUID id) throws Exception {
        Optional<User> user = this.userRepository.findById(id);

        if (user.isEmpty()) {
            throw new Exception("User not found.");
        }

        return user.get();
    }

    public List<User> findAllUsers(){
        return this.userRepository.findAll();
    }
}
