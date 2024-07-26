package com.eduardo.meeting.services;

import com.eduardo.meeting.DTOs.MeetingRequestDTO;
import com.eduardo.meeting.entities.Meeting;
import com.eduardo.meeting.entities.User;
import com.eduardo.meeting.mappers.MeetingMapper;
import com.eduardo.meeting.repositories.MeetingRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final UserService userService;

    public MeetingService(MeetingRepository meetingRepository,
                          UserService userService) {
        this.meetingRepository = meetingRepository;
        this.userService = userService;
    }

    public Meeting save(MeetingRequestDTO meeting) throws Exception {
        User meetingOrganizer = this.userService.findUserById(meeting.organizerId());
        Meeting meetingEntity = MeetingMapper.requestToEntity(meeting);
        meetingEntity.setMeetingOrganizer(meetingOrganizer);
        this.meetingRepository.save(meetingEntity);
        this.addParticipants(meeting.participantsIds(), meetingEntity.getId());
        return meetingEntity;
    }

    public List<Meeting> findAllByOrganizerId(UUID organizerId) throws Exception {
        User meetingOrganizer = this.userService.findUserById(organizerId);

        return this.meetingRepository.findAllByMeetingOrganizer(meetingOrganizer);
    }

    public Meeting findById(UUID meetingId) throws Exception {
        Optional<Meeting> meeting = this.meetingRepository.findById(meetingId);

        if (meeting.isEmpty()) {
            throw new Exception("Meeting not found");
        }

        return meeting.get();
    }

    public void addParticipants(List<UUID> participantsIds, UUID meetingId) throws Exception {
        Meeting meeting = this.findById(meetingId);

        for (UUID id : participantsIds) {
            if (meeting.getParticipants().stream().noneMatch(user -> user.getId().equals(id))) {
                try {
                    User user = userService.findUserById(id);
                    meeting.addParticipant(user);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to find user with ID: " + id, e);
                }
            }
        }
        this.meetingRepository.save(meeting);
    }
}
