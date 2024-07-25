package com.eduardo.meeting.repositories;

import com.eduardo.meeting.entities.Meeting;
import com.eduardo.meeting.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MeetingRepository extends JpaRepository<Meeting, UUID> {
    List<Meeting> findAllByMeetingOrganizer(User meetingOrganizer);
}
