package com.jone.coffee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@NoArgsConstructor
@Data
public class Account {
	
	public Account(String username, String email, String password, String role) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$", message =  "username không được chứa kí tự đặc biệt")
	@NotBlank(message = "username không được để trống")
	@Column(name = "username", columnDefinition = "NVARCHAR(50)", nullable = false, unique = true)
	private String username;

	@Email(message = "nhập đúng định dạng email 'abc@gmail.com'")
	@Column(name = "email", columnDefinition = "VARCHAR(200)")
	private String email;
	
	@NotBlank(message = "password không được để trống")
	@Column(name = "password", columnDefinition = "VARCHAR(200)", nullable = false)
	private String password;
	
	@Column(name = "role", columnDefinition = "VARCHAR(20)", nullable = false)
	private String role;
	
	@Column(name = "active", columnDefinition = "BIT")
	private boolean active;
}
