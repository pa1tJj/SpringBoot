package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;
import com.example.demo.repository.custom.ProductRepositoryCustom;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom{

}
