package com.jone.coffee.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

	@NotBlank(message = "không được để trống ID")
	private String id;
	
	@Pattern(regexp = "^[\\p{L}\\p{M}0-9 _-]+$", message =  "tên sản phẩm không được chứa kí tự đặc biệt")
	@NotBlank(message = "tên sản phẩm không được để trống")
	@Size(min = 5, max = 50, message = "độ dài tên sản phẩm trong khoảng 5 -> 50 kí tự")
	private String name;	

	@Positive(message = "số lượng phải lớn hơn 0")
	private Long quantity;
	
	@Min(value = 1, message = "giá phải lớn hơn 1")
	private Long price;
}
