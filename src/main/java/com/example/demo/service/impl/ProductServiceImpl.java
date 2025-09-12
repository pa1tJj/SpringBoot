package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductDTO;
import com.example.demo.model.ProductRequest;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

	private ProductRepository productsRepository;
	
	@Override
	public List<ProductDTO> findProducts(ProductRequest productRequest, Pageable pageable) {
		Page<Product> products = productsRepository.findProduct(productRequest, pageable, totalPageItem());
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		for(Product item : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(item.getId());
			productDTO.setName(item.getName());
			productDTO.setPrice(item.getPrice());
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public int totalPageItem() {		
		return (int) productsRepository.count() / 3;
	}

}
