package com.example.sistema.de.reservas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.sistema.de.reservas.models.entities.Reservation;
import com.example.sistema.de.reservas.services.ReservationService;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationResource {

	@Autowired
	private ReservationService reservationService;

	@GetMapping
	public ResponseEntity<List<Reservation>> findAll() {
		List<Reservation> list = reservationService.findAllReservations();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Reservation> findById (@PathVariable Long id){
		Reservation obj = reservationService.findReservationById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Reservation> insert(@RequestBody Reservation obj){
		obj = reservationService.creatReservation(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getReservationId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		reservationService.deleteReservation(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Reservation> update(@PathVariable Long id,@RequestBody Reservation obj ){
		obj = reservationService.updateReservation(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}