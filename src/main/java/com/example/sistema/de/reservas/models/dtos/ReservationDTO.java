package com.example.sistema.de.reservas.models.dtos;

public class ReservationDTO {
    private Integer ticketsAmount;
    private Long userId;
    private Long eventId;
	
    public ReservationDTO() {
		
	}

	public ReservationDTO(Integer ticketsAmount, Long userId, Long eventId) {
		this.ticketsAmount = ticketsAmount;
		this.userId = userId;
		this.eventId = eventId;
	}

	public Integer getTicketsAmount() {
		return ticketsAmount;
	}

	public void setTicketsAmount(Integer ticketsAmount) {
		this.ticketsAmount = ticketsAmount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
    
    

    
}