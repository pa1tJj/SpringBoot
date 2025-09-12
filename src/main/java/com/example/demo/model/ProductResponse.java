package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ProductResponse {
	private Integer pageNumber;
	private Integer totalPage;
	private List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
}
