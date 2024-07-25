package com.eduardo.meeting.services;

import com.eduardo.meeting.DTOs.MeetingRequestDTO;
import com.eduardo.meeting.entities.Meeting;
import com.eduardo.meeting.entities.User;
import com.eduardo.meeting.mappers.MeetingMapper;
import com.eduardo.meeting.repositories.MeetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        Optional<User> meetingOrganizer = this.userService.findUserById(meeting.organizerId());

        if (meetingOrganizer.isEmpty()) {
            throw new Exception("User not found.");
        }

        Meeting meetingEntity = MeetingMapper.requestToEntity(meeting);
        meetingEntity.setMeetingOrganizer(meetingOrganizer.get());

        return this.meetingRepository.save(meetingEntity);
    }

    public List<Meeting> findAllByOrganizerId(UUID organizerId) throws Exception {
        Optional<User> meetingOrganizer = this.userService.findUserById(organizerId);

        if (meetingOrganizer.isEmpty()) {
            throw new Exception("User not found.");
        }

        return this.meetingRepository.findAllByMeetingOrganizer(meetingOrganizer.get());
    }
}
