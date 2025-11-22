package com.jone.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jone.coffee.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	//Jpa này cần 2 thông số 
	//tên entity class
	// cột key có kiểu data type nào đó
	//nhờ 2 thông số này, Jpa/Hibernate phía hậu trường nó tự generate ra các hàm CRUD table Category 
	// và hơn thế nữa: nó tự generate ra 1 loạt các hàm tương ứng với 1 loạt các câu SQL hay dùng trên 1 tablw
	//về cơ bản , hầu như không cần viết thêm các hàm CRUD table ứng với các where của riêng mình, Spring lo được các hàm này
	// ===> để tận dụng cơ chế tự sinh hàm, bạn cần viết tên hàm theo chuẩn Spring Data JPA quy ước trước, tự Spring lo nốt câu JPQL/SQL cho bạn
	//-> kĩ thuật tự sinh hàm và câu query chỉ từ cách đặt tên hàm theo chuẩn khi gọi la f: DRIVED QURY MEHTOD, QUERY METHOD
	//KEYWORD: "QUERY METHODS IN SPRING DATA JPA"
}
