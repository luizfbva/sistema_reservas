package com.example.sistema.de.reservas.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

	private Long userId;

	@NotBlank(message = "Name is required")
	@Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
	private String userName;

	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	private String userEmail;
	
	@NotBlank(message = "Phone is required")
	private String userPhone;

	public UserDTO() {

	}

	public UserDTO(String userName, String userEmail, String userPhone, Long userId) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userId = userId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
