package com.example.sistema.de.reservas.models.dtos;

import java.io.Serializable;
import java.time.Instant;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EventDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long eventId;

    @NotNull(message = "Event date cannot be null")
    @Future(message = "Event date must be in the future")
    private Instant eventDate;

    @NotBlank(message = "Event name cannot be empty")
    private String eventName;

    @NotBlank(message = "Event description cannot be empty")
    @Size(max = 500, message = "Event description must be at most 500 characters long")
    private String eventDescription;

    public EventDTO() {
    }

    public EventDTO(Long eventId, Instant eventDate, String eventName, String eventDescription) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Instant getEventDate() {
        return eventDate;
    }

    public void setEventDate(Instant eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
