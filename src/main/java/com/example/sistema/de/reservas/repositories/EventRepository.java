package com.example.sistema.de.reservas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.de.reservas.models.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long>{


}
