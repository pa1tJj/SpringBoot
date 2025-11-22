package com.jone.javweb.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auth")
@Data
@NoArgsConstructor
public class Auth {

	public Auth(String phone, String fullname, String password, String role) {
		super();
		this.phone = phone;
		this.fullname = fullname;
		this.password = password;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "phone", columnDefinition = "VARCHAR(15)", unique = true)
	private String phone;
	
	@Column(name = "fullname", columnDefinition = "NVARCHAR(100)")
	private String fullname;
	
	@Column(name = "password", columnDefinition = "VARCHAR(255)")
	private String password;
	
	@Column(name = "role", columnDefinition = "VARCHAR(20)")
	private String role;
}
