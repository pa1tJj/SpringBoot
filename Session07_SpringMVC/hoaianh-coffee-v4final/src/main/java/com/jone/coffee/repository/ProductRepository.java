package com.jone.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jone.coffee.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
	//SPRINGBOOT, SPRING JPA, SPRING HIBERNATE CÓ 2 CƠ CHẾ SINH HÀM TỰ ĐỘNG CHO MỖI ENTITY/TABLE
	//NHỮNG HÀM CƠ BẢN HAY SỬ DỤNG
	//JPA/HIBERNATE NÓ SẼ SINH SẴN TRƯỚC CÁC HÀM NÀY -> BUILD-IN SẴN KHÔNG CẦN KHAI BÁO Ở REPO MÀ GỌI LUÔN Ở SERVICE
	
}
