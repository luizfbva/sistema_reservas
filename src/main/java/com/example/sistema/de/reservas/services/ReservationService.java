package com.example.sistema.de.reservas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.sistema.de.reservas.models.entities.Reservation;
import com.example.sistema.de.reservas.repositories.ReservationRepository;
import com.example.sistema.de.reservas.services.exceptions.DatabaseException;
import com.example.sistema.de.reservas.services.exceptions.ResourceNotFoundException;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private EventService eventService;

	public List<Reservation> findAllReservations() {
		return reservationRepository.findAll();
	}

	public Reservation findReservationById(Long id) {
		Optional<Reservation> obj = reservationRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Reservation creatReservation(Reservation obj) {
		return reservationRepository.save(obj);
	}

	public void deleteReservation(Long id) {
		try {
			Reservation reservationById = findReservationById(id);
			eventService.returnTicketsFromDeleteReservation(reservationById.getEvent(), reservationById.getTicketsAmount());
			reservationRepository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}
	
	public List<Reservation> findAllByUserId(Long userId) {
		return reservationRepository.findAllByUserId(userId);
	}

}
