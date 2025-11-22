package com.jone.javweb.model.dto;

import org.springframework.web.multipart.MultipartFile;

import com.jone.javweb.model.entity.Genre;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;
    
    @NotBlank(message = "tên không được để trống")
    @Pattern(regexp = "^[\\\\\\\\p{L}\\\\\\\\p{M}0-9 _-]+$", message = "tên không được chứa kí tự đặc biệt")
	private String name;
    
    @NotBlank(message = "không được để trống")
	private String duration;
    
    
	private MultipartFile image;
	
	@NotNull(message = "không được để trống")
	@Min(value = 1, message = "số lượng tập phải lớn hơn 1")
	private Long episodes;
	
	@NotBlank(message = "không được để trống")
	private String detail;
	private Genre genre;
	private String actor;
}
