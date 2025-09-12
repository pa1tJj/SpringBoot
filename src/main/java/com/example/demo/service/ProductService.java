package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.model.ProductDTO;
import com.example.demo.model.ProductRequest;

public interface ProductService {

	public List<ProductDTO> findProducts(ProductRequest productRequest, Pageable pageable);
	
	public int totalPageItem();
}
