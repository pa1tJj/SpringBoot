package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ProductDTO;

public interface ProductService {

	public List<ProductDTO> findAllProduct(Integer pageNumber);
}
