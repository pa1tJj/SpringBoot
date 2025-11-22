package com.jone.coffee.service;

import org.springframework.stereotype.Service;

import com.jone.coffee.dto.ProductDTO;
import com.jone.coffee.entity.Product;
import com.jone.coffee.repository.ProductRepo;

@Service
public class ProductService {
	
	private final ProductRepo productRepo;
	
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	public void save(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		productRepo.save(product);
	}
	
	public ProductDTO result() {
		Product product = productRepo.findById("sp01");
		ProductDTO dto = new ProductDTO();
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		dto.setQuantity(product.getQuantity());
		return dto;
	}
}
