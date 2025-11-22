package com.jone.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jone.coffee.entity.Product;

public interface ProductRepo extends JpaRepository<Product, String>{

	Product findById(String id);
}
