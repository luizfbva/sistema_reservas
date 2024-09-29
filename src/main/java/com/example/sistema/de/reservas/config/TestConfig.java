package com.example.sistema.de.reservas.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.sistema.de.reservas.models.entities.Event;
import com.example.sistema.de.reservas.models.entities.Reservation;
import com.example.sistema.de.reservas.models.entities.User;
import com.example.sistema.de.reservas.repositories.EventRepository;
import com.example.sistema.de.reservas.repositories.ReservationRepository;
import com.example.sistema.de.reservas.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private ReservationRepository reservationRepository;
	

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(1L, "Alice Johnson", "alice.johnson@example.com", "555-1234");
		User user2 = new User(2L, "Bob Smith", "bob.smith@example.com", "555-5678");

		userRepository.saveAll(Arrays.asList(user1, user2));

		Event event1 = new Event(1L, Instant.parse("2024-10-01T10:00:00Z"), "Concert", "Music concert in the park", 10);
		Event event2 = new Event(2L, Instant.parse("2024-10-15T18:00:00Z"), "Art Exhibition",
				"Exhibition of modern art", 10);

		eventRepository.saveAll(Arrays.asList(event1, event2));

		Reservation reservation1 = new Reservation(1L, 1, user1, event1);
		Reservation reservation2 = new Reservation(2L, 2, user2, event2);

		reservationRepository.saveAll(Arrays.asList(reservation1, reservation2));
		
		event1.getReservations().add(reservation1);
		event2.getReservations().add(reservation2);

		eventRepository.saveAll(Arrays.asList(event1, event2));

	}

}
