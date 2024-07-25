package com.eduardo.meeting.DTOs;

import java.util.UUID;

public record UserResponseDTO(UUID id, String username, String email) {
}
