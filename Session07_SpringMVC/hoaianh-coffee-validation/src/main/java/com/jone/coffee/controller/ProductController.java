package com.jone.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jone.coffee.dto.ProductDTO;
import com.jone.coffee.service.ProductService;

@Controller
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/product")
	public String getProduct(Model model) {
		model.addAttribute("productEdit", new ProductDTO());
		return "product";
	}
	
	@GetMapping("/result")
	public String result(Model model) {
		model.addAttribute("result", productService.result());
		return "result";
	}
}
