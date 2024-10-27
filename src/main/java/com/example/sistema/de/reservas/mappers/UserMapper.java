package com.example.sistema.de.reservas.mappers;

import org.springframework.stereotype.Component;

import com.example.sistema.de.reservas.models.dtos.UserDTO;
import com.example.sistema.de.reservas.models.entities.User;

@Component
public class UserMapper {

	public UserDTO toDTO(User user) {
		if(user == null) {
			return null;
		}
		UserDTO dto = new UserDTO();
		dto.setUserName(user.getUserName());
		dto.setUserEmail(user.getUserEmail());
		dto.setUserPhone(user.getUserPhone());
		return dto;
	}
	
	public User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setUserEmail(dto.getUserEmail());
        user.setUserPhone(dto.getUserPhone());
        return user;
    }

}
