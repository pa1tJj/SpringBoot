package com.example.demo.repository.custom.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductRequest;
import com.example.demo.repository.custom.ProductRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<Product> findProduct(ProductRequest productRequest, Pageable pageable, int total) {
		StringBuilder sql = new StringBuilder("SELECT * FROM products WHERE 1 = 1");
		if(productRequest.getName() != null && !productRequest.getName().isEmpty()) {
			sql.append(" AND name LIKE :name");
		} else if(productRequest.getMaxPrice() != null || productRequest.getMinPrice() != null) {
			sql.append(" AND price BETWEEN :minPrice AND :maxPrice");
		} 
		Query query = entityManager.createNativeQuery(sql.toString(), Product.class);
		if(productRequest.getName() != null && !productRequest.getName().isEmpty()) {
			query.setParameter("name", "%" + productRequest.getName() + "%");			
		} else if(productRequest.getMaxPrice() != null || productRequest.getMinPrice() != null) {
			query.setParameter("minPrice", productRequest.getMinPrice());
			query.setParameter("maxPrice", productRequest.getMaxPrice());		
		}
		query.setFirstResult((int) pageable.getOffset());
	    query.setMaxResults(pageable.getPageSize());
		return new PageImpl<Product>(query.getResultList(), pageable, total);
	}

}
