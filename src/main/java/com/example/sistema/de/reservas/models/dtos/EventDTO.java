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
    private Instant eventDate;
    private String eventName;
    private String eventDescription;

    public EventDTO() {
    }

    public EventDTO(Instant eventDate, String eventName, String eventDescription, Long eventId) {
        this.eventDate = eventDate;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventId = eventId;
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
