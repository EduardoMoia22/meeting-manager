package com.eduardo.meeting.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

public record MeetingResponseDTO(UUID id,
                                 String title,
                                 String description,
                                 LocalDateTime startTime,
                                 LocalDateTime notificationTime,
                                 UserResponseDTO meetingOrganizer) {
}
