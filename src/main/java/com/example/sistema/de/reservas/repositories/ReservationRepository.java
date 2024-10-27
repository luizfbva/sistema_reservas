package com.example.sistema.de.reservas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.de.reservas.models.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	List<Reservation> findAllByUserId(Long userId);


}
