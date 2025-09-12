package com.example.demo.repository.custom;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductRequest;

public interface ProductRepositoryCustom {

	public Page<Product> findProduct(ProductRequest productRequest, Pageable pageable, int total);
}
