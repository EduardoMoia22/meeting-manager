package com.eduardo.meeting.mappers;

import com.eduardo.meeting.DTOs.MeetingRequestDTO;
import com.eduardo.meeting.DTOs.MeetingResponseDTO;
import com.eduardo.meeting.entities.Meeting;

public class MeetingMapper {
    public static MeetingResponseDTO toResponseDTO(Meeting meeting) {
        return new MeetingResponseDTO(meeting.getId(),
                meeting.getTitle(),
                meeting.getDescription(),
                meeting.getStartTime(),
                meeting.getNotificationTime(),
                UserMapper.toResponseDTO(meeting.getMeetingOrganizer())
        );
    }

    public static Meeting requestToEntity(MeetingRequestDTO meetingRequestDTO) {
        return new Meeting(
                meetingRequestDTO.title(),
                meetingRequestDTO.description(),
                meetingRequestDTO.startTime(),
                meetingRequestDTO.notificationTime()
        );
    }

}
