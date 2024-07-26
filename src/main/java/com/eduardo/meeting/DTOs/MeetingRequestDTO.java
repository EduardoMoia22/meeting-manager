package com.eduardo.meeting.DTOs;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record MeetingRequestDTO(String title,
                                String description,
                                LocalDateTime startTime,
                                LocalDateTime notificationTime,
                                UUID organizerId,
                                List<UUID> participantsIds) {
}
