package com.jone.javweb.model.response;

import com.jone.javweb.model.entity.Genre;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

	private Long id;
	private String name;
	private String duration;
	private String image;
	private Long episodes;
	private String detail;
	private Genre genre;
	private String actor;

}
