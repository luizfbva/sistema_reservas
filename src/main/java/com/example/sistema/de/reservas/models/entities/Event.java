package com.example.sistema.de.reservas.models.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_event")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant eventDate;
	private String eventName;
	private String eventDescription;
	private Integer eventTotalTickets;
	private Integer eventAvailableTickets;

	@JsonIgnore
	@OneToMany(mappedBy = "event")
	private List<Reservation> reservations = new ArrayList<>();

	public Event() {

	}

	public Event(Long eventId, Instant eventDate, String eventName, String eventDescription,
			Integer eventTotalTickets) {
		super();
		this.eventId = eventId;
		this.eventDate = eventDate;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventTotalTickets = eventTotalTickets;
		this.eventAvailableTickets = eventTotalTickets;
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

	@JsonIgnore
	public Integer getEventTotalTickets() {
		return eventTotalTickets;
	}

	public void setEventTotalTickets(Integer eventTotalTickets) {
		this.eventTotalTickets = eventTotalTickets;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setEventAvailableTickets(Integer eventAvailableTickets) {
		this.eventAvailableTickets = eventAvailableTickets;
	}

	public Integer getEventAvailableTickets() {
		return eventAvailableTickets;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(eventId, other.eventId);
	}

}
