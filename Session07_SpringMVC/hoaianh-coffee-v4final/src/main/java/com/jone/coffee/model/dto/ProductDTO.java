package com.jone.coffee.model.dto;

import com.jone.coffee.entity.Category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {
	
	private Long id;
	

	@Pattern(regexp = "^(?! )[\\p{L}\\p{M}0-9 _-]+(?<! )$", message =  "tên sản phẩm không được chứa kí tự đặc biệt")
	@NotBlank(message = "tên sản phẩm không được để trống")
	@Size(min = 5, max = 50, message = "độ dài tên sản phẩm trong khoảng 5 -> 50 kí tự")
	private String name;

	@Positive(message = "số lượng phải lớn hơn 0")
	@NotNull(message = "số lượng không được để trống")
	private Long quantity;
	
	@Min(value = 1, message = "giá phải lớn hơn 1")
	@NotNull(message = "giá không được để trống")
	private Long price;
	
	private Category category;
}
