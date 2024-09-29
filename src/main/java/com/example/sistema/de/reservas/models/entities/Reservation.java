package com.example.sistema.de.reservas.models.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_reservation")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long reservationId;
	private Integer ticketsAmount;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	
	public Reservation() {
		
	}

	public Reservation(Long reservationId, Integer ticketsAmount, User user, Event event) {
		super();
		this.reservationId = reservationId;
		this.ticketsAmount = ticketsAmount;
		this.user = user;
		this.event = event;
		
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Integer getTicketsAmount() {
		return ticketsAmount;
	}

	public void setTicketsAmount(Integer ticketsAmount) {
		this.ticketsAmount = ticketsAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reservationId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(reservationId, other.reservationId);
	}
	
	
	
	
}
