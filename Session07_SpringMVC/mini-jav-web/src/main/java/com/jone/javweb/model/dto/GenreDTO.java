package com.jone.javweb.model.dto;

import lombok.Data;

@Data
public class GenreDTO {

	public GenreDTO(String name) {
		this.name = name;
	}
	private Long id;
	private String name;
}
