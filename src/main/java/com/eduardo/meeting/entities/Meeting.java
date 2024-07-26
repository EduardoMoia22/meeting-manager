package com.eduardo.meeting.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_meetings")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime notificationTime;

    @ManyToOne
    private User meetingOrganizer;

    @ManyToMany
    @JoinTable(
            name = "tb_meeting_participants",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> participants = new ArrayList<>();;

    public Meeting() {
    }

    public Meeting(String title, String description, LocalDateTime startTime, LocalDateTime notificationTime) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.notificationTime = notificationTime;
    }

    public void addParticipant(User participant) {
        if (participant != null && !this.participants.contains(participant)) {
            this.participants.add(participant);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(LocalDateTime notificationTime) {
        this.notificationTime = notificationTime;
    }

    public User getMeetingOrganizer() {
        return meetingOrganizer;
    }

    public void setMeetingOrganizer(User meetingOrganizer) {
        this.meetingOrganizer = meetingOrganizer;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
