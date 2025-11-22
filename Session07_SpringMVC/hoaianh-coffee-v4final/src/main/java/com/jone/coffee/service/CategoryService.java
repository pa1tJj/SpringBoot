package com.jone.coffee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jone.coffee.entity.Category;
import com.jone.coffee.repository.CategoryRepository;

@Service
public class CategoryService {
	// GUI/CONTAINER ---> SERVICE ---> REPOSITORY ---> SPRING JPA/HIBERNATE ---> JDBC DRIVER ---> TABLE
	// SERVICE LO CRUD TABLE TRONG RAM, LO LOGIC XỬ LÍ VỚI ENTITY/DTO, VÍ DỤ TÍNH VOUCHER, KHUYẾN MÃI, GỌI CỔNG THANH TOÁN, GỬI MAIL NOTI...
	//NẾU LO VIỆC CRUD TABLE THÌ PHẢI NHỜ VÀ REPO
	//BẢN CHẤT LÀ PHẢI KHAI BÁO REPO, NEW REPO(), GỌI HÀM REPO
	//NHƯNG REPO HIỆN NAY ĐANG LÀ INTERFACE VÀ LÀ BEAN, CHO NÊN SẼ NHỜ IOC CONTAINER TIÊM/CHÍCH VÀO SERVICE
	//VẬY SERVICE ĐC TIÊM VÀO REPO VÀO, VẬY SERVICE CŨNG LÀ BEAN
	
	
	//tiêm repository: có 3 cách
	//@Autowired//có 1 đống hàm tự sinh ra cho CRUD Cate rồi - query method trong biến ccategoryRepository
	private CategoryRepository categoryRepository;

	//tiêm qua constructor
	//không cần @Autowired nếu class chỉ có 1 cast này!!! tiêm ngay lúc new, chỉ có 1 đường new
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category> getCategory() {
		return categoryRepository.findAll();
	}
	
	public Category findCategoryById(Long id) {
		return categoryRepository.findById(id).get();
	}
}
