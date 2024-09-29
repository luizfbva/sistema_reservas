package com.example.sistema.de.reservas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.de.reservas.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{


}
