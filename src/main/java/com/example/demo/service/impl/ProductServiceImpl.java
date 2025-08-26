package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductDTO;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

	private ProductsRepository productsRepository;
	
	@Override
	public List<ProductDTO> findAllProduct(Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, 2);
		Page<Product> products = productsRepository.findAll(pageable);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		for(Product item : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(item.getId());
			productDTO.setName(item.getName());
			productDTO.setPrice(item.getPrice());
			productDTOs.add(productDTO);
		}
		return  productDTOs;
	}

}
