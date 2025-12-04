package com.jone.springredis.dto;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String image;
}
