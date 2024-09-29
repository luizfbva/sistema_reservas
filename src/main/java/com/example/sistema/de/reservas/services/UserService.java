package com.example.sistema.de.reservas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.sistema.de.reservas.mappers.UserMapper;
import com.example.sistema.de.reservas.models.dtos.UserDTO;
import com.example.sistema.de.reservas.models.entities.User;
import com.example.sistema.de.reservas.repositories.UserRepository;
import com.example.sistema.de.reservas.services.exceptions.DatabaseException;
import com.example.sistema.de.reservas.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        User obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return userMapper.toDTO(obj);
    }

    public UserDTO insert(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = repository.save(user);
        return userMapper.toDTO(user);
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

    public UserDTO update(Long id, UserDTO userDTO) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, userMapper.toEntity(userDTO));
            entity = repository.save(entity);
            return userMapper.toDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setUserName(obj.getUserName());
        entity.setUserEmail(obj.getUserEmail());
        entity.setUserPhone(obj.getUserPhone());
    }
}
