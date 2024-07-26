package com.eduardo.meeting.controllers;

import com.eduardo.meeting.DTOs.UserRequestDTO;
import com.eduardo.meeting.DTOs.UserResponseDTO;
import com.eduardo.meeting.mappers.UserMapper;
import com.eduardo.meeting.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(UserMapper.toResponseDTO(userService.save(userRequestDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable UUID id) throws Exception{
        return ResponseEntity.ok(UserMapper.toResponseDTO(this.userService.findUserById(id)));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAllUsers() {
        return ResponseEntity.ok(this.userService.findAllUsers()
                                                 .stream()
                                                 .map(UserMapper::toResponseDTO)
                                                 .collect(Collectors.toList()));
    }
}
