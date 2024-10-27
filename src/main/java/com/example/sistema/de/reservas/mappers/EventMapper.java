package com.example.sistema.de.reservas.mappers;

import org.springframework.stereotype.Component;

import com.example.sistema.de.reservas.models.dtos.EventDTO;
import com.example.sistema.de.reservas.models.entities.Event;

@Component
public class EventMapper {

	public EventDTO toDTO(Event event) {
		if (event == null) {
			return null;
		}
		return new EventDTO(
				event.getEventDate(), 
				event.getEventName(),
				event.getEventDescription(),
				event.getEventId());
	}

	public Event toEntity(EventDTO dto) {
		if (dto == null) {
			return null;
		}
		Event entity = new Event();
		dto.getEventDate();
		dto.getEventName();
		dto.getEventDescription();
		return entity;
	}
}