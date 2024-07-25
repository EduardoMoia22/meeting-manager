package com.eduardo.meeting.controllers;

import com.eduardo.meeting.DTOs.MeetingRequestDTO;
import com.eduardo.meeting.DTOs.MeetingResponseDTO;
import com.eduardo.meeting.entities.Meeting;
import com.eduardo.meeting.mappers.MeetingMapper;
import com.eduardo.meeting.services.MeetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/meetings")
public class MeetingController {
    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping
    public ResponseEntity<MeetingResponseDTO> saveMeeting(@RequestBody MeetingRequestDTO meetingRequestDTO) throws Exception {
        return ResponseEntity.ok(MeetingMapper.toResponseDTO(this.meetingService.save(meetingRequestDTO)));
    }

    @GetMapping("/{organizerId}")
    public ResponseEntity<List<MeetingResponseDTO>> findAllByOrganizerId(@PathVariable UUID organizerId) throws Exception {
        List<Meeting> meetings = this.meetingService.findAllByOrganizerId(organizerId);

        return ResponseEntity.ok(meetings.stream()
                .map(MeetingMapper::toResponseDTO)
                .collect(Collectors.toList()));
    }
}
