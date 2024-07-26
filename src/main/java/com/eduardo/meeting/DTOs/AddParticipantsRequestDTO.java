package com.eduardo.meeting.DTOs;

import java.util.List;
import java.util.UUID;

public record AddParticipantsRequestDTO(List<UUID> participantsIds) {
}
