package com.example.sistema.de.reservas.models.dtos;

import org.springframework.beans.BeanUtils;

import com.example.sistema.de.reservas.models.entities.User;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

public class UserDTO {

	private Long userId;
	private String userName;
	private String userEmail;
	private String userPhone;

	public UserDTO() {

	}

	public UserDTO(User user) {
		BeanUtils.copyProperties(user, this);
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

}
