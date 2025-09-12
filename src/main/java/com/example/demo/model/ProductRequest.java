package com.example.demo.model;

import lombok.Data;

@Data
public class ProductRequest{
	private int page = 1;
	private Integer maxPageItem = 3;
	private String name;
	private Long minPrice;
	private Long maxPrice;
}
