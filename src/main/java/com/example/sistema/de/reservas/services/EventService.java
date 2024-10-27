package com.example.sistema.de.reservas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.sistema.de.reservas.mappers.EventMapper;
import com.example.sistema.de.reservas.models.dtos.EventDTO;
import com.example.sistema.de.reservas.models.entities.Event;
import com.example.sistema.de.reservas.models.entities.Reservation;
import com.example.sistema.de.reservas.repositories.EventRepository;
import com.example.sistema.de.reservas.services.exceptions.DatabaseException;
import com.example.sistema.de.reservas.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	@Autowired
	private EventMapper eventMapper;

	public List<EventDTO> findAll() {
		List<Event> events = repository.findAll();
		return events.stream().map(eventMapper::toDTO).collect(Collectors.toList());
	}

	public EventDTO findById(Long id) {
		Event event = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return eventMapper.toDTO(event);
	}

	public EventDTO insert(EventDTO dto) {
		Event event = eventMapper.toEntity(dto);
		event = repository.save(event);
		return eventMapper.toDTO(event);
	}

	public void delete(Long id) {
		try {
			findById(id);
			repository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public EventDTO update(Long id, EventDTO dto) {
		try {
			Event entity = repository.getReferenceById(id);
			updateEvent(entity, dto);
			return eventMapper.toDTO(repository.save(entity));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateEvent(Event entity, EventDTO dto) {
		entity.setEventDate(dto.getEventDate());
		entity.setEventDescription(dto.getEventDescription());
		entity.setEventName(dto.getEventName());
	}

	public void updateAvailableTickets(Long eventId) {
		Event event = eventMapper.toEntity(findById(eventId));
		int sum = 0;
		for (Reservation reservation : event.getReservations()) {
			sum += reservation.getTicketsAmount();
		}

		event.setEventAvailableTickets(event.getEventTotalTickets() - sum);
		repository.save(event);
	}

	public void returnTicketsFromDeleteReservation(Event event, Integer ticketsAmount) {
		event.addAvailableTickets(ticketsAmount);
		repository.save(event);

	}
}
