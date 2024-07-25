package com.eduardo.meeting.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
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

    public Meeting() {
    }

    public Meeting(String title, String description, LocalDateTime startTime, LocalDateTime notificationTime) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.notificationTime = notificationTime;
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
}
