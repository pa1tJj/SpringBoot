package com.jone.coffee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jone.coffee.entity.Category;
import com.jone.coffee.entity.Product;
import com.jone.coffee.model.dto.ProductDTO;
import com.jone.coffee.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;
	private final CategoryService categoryService;
	
	public ProductService(ProductRepository productRepository, CategoryService categoryService) {
		this.productRepository = productRepository;
		this.categoryService = categoryService;
	}
	
	public List<ProductDTO> getProducts() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for(Product item: products) {
			ProductDTO dto = new ProductDTO();
			dto.setId(item.getId());
			dto.setName(item.getName());
			dto.setPrice(item.getPrice());
			dto.setQuantity(item.getQuantity());
			dto.setCategory(new Category(item.getCategory().getName(), item.getCategory().getDescription()));
			result.add(dto);
		}
		return result;
	}
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public ProductDTO getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(id);
		productDTO.setName(product.get().getName());
		productDTO.setPrice(product.get().getPrice());
		productDTO.setQuantity(product.get().getQuantity());
		productDTO.setCategory(product.get().getCategory());
		return productDTO;
	}
	
	public void productCreate(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		Category category = categoryService.findCategoryById(productDTO.getCategory().getId());
		product.setCategory(category);
		productRepository.save(product);
	}
}
