package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductDTO;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/test")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public List<ProductDTO> findAllProduct(@RequestParam Integer pageNumber) {
		return productService.findAllProduct(pageNumber);
	}
	
}
