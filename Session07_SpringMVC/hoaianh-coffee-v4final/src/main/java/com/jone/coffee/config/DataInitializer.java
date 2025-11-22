package com.jone.coffee.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jone.coffee.entity.Account;
import com.jone.coffee.entity.Category;
import com.jone.coffee.entity.Product;
import com.jone.coffee.service.AuthService;
import com.jone.coffee.service.CategoryService;
import com.jone.coffee.service.ProductService;

//tự chạy 1 lần duy nhất khi tomcat được chạy, là IOC CONTAINER chạy, dùng đê tạo table, tạo sẵn data trong table
@Component
public class DataInitializer implements CommandLineRunner {

	// NHỜ VẢ 3 SERVICE GIÚP TẠO TABLE VÀ CHÈN SẪN DATA
	private final CategoryService categoryService;
	private final ProductService productService;
	private final AuthService authService;

	public DataInitializer(CategoryService categoryService, ProductService productService, AuthService authService) {
		this.categoryService = categoryService;
		this.productService = productService;
		this.authService = authService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TẠO OBJECT, NHỜ SERVICE ĐẨY XUỐNG
		// TAO TABLE 1 TRƯỚC, N SAU (DO KHÓA NGOẠI THAM CHIẾU KHÓA CHÍNH)

		Category c1 = new Category("trà sữa", "uống trà sữa như con cặc");
		Category c2 = new Category("cà phê", "uống cà phê code java - địt mẹ tuyệt vời");
		Category c3 = new Category("bia bọt", "uống bia đéo ngon");
		Category c4 = new Category("bánh kẹo", "ăn kẹo ngọt");

		categoryService.saveCategory(c1);
		categoryService.saveCategory(c2);
		categoryService.saveCategory(c3);
		categoryService.saveCategory(c4);
		
		Product p1 = new Product("trà sữa hàng xóm nấu", 66L, 342342L, c1);
		Product p2 = new Product("trà sữa highland", 89L, 34243L, c2);
		Product p3 = new Product("cà phê mang đi", 75L, 34342L, c3);
		Product p4 = new Product("cà phê Java", 100L, 22222L, c4);
		
		productService.saveProduct(p1);
		productService.saveProduct(p2);
		productService.saveProduct(p3);
		productService.saveProduct(p4);
		
		Account a1 = new Account("phan", "p@gmail.com", "1234", "admin");
		Account a2 = new Account("anh", "a@gmail.com", "2222", "staff");
		Account a3 = new Account("nhat", "n@gmail.com", "4321", "manager");
		Account a4 = new Account("minh", "m@gmail.com", "1111", "admin");
		
		authService.saveAccount(a1);
		authService.saveAccount(a2);
		authService.saveAccount(a3);
		authService.saveAccount(a4);
	}

}
