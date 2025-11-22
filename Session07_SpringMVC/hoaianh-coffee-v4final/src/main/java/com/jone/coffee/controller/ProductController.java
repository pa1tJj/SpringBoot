package com.jone.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jone.coffee.model.dto.ProductDTO;
import com.jone.coffee.service.CategoryService;
import com.jone.coffee.service.ProductService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProductController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}

	@GetMapping("/product")
	public String getProducts(Model model, HttpSession session) {
		String role = (String)session.getAttribute("role");
		model.addAttribute("role", role);
		model.addAttribute("products", productService.getProducts());
		return "products";
	}
	
	@GetMapping("/product-edit-{id}")
	public String getProduct(Model model, @PathVariable Long id, HttpSession session) {
		model.addAttribute("productEdit", productService.getProductById(id));
		model.addAttribute("categories", categoryService.getCategory());
		String role = (String)session.getAttribute("role");
		if(role != null) {
			return "product-form";
		} else {
			return "redirect:/login";
		}	
	}
	
	@GetMapping("/product-edit")
	public String getProduct(Model model, HttpSession session) {
		model.addAttribute("productEdit", new ProductDTO());
		model.addAttribute("categories", categoryService.getCategory());
		String role = (String)session.getAttribute("role");
		if(role != null) {
			return "product-form";
		} else {
			return "redirect:/login";
		}		
	}
	
	@PostMapping("/save-product")
	public String save(@Valid @ModelAttribute("productEdit") ProductDTO productDTO, BindingResult bindingResult, Model model) {
		model.addAttribute("categories", categoryService.getCategory());
		if(bindingResult.hasErrors()) {
			return "product-form";
		} else {
			return "forward:/product-create";//forward sẽ giữ nguyên phương thức HTTP ban đầu @PostMapping("/save-product") khi gửi
		}
	}
}
