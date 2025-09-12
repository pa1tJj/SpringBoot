package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.ProductRequest;
import com.example.demo.model.ProductResponse;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/test")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public ModelAndView findAllProduct(@ModelAttribute ProductRequest productRequest) {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("request", new ProductRequest());
		ProductResponse productResponse = new ProductResponse();
		productResponse.setProductDTOs(productService.findProducts(productRequest, PageRequest.of(productRequest.getPage() - 1, productRequest.getMaxPageItem())));
		productResponse.setTotalPage(productService.totalPageItem());
		mav.addObject("product", productResponse);
		return mav;
	}
	
}
