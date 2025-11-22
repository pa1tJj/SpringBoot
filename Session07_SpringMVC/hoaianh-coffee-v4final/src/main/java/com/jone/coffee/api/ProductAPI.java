package com.jone.coffee.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jone.coffee.model.dto.ProductDTO;
import com.jone.coffee.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductAPI {
	private final ProductService productService;
	
	public ProductAPI(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/product-create")
	public ResponseEntity<Void> productCreate(@Valid @ModelAttribute("productEdit") ProductDTO productDTO) {
		productService.productCreate(productDTO);
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.header("location", "/product")
				.build();
	}
	
	
}
