package com.jone.coffee.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jone.coffee.dto.ProductDTO;
import com.jone.coffee.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductAPI {
	private final ProductService productService;
	
	public ProductAPI(ProductService productService) {
		this.productService = productService;
	}

	
	//KĨ THUẬT BEAN VALIDATION, CHỈ ĐC SỬ DỤNG NẾU DÙNG CƠ CHẾ BINDING OBJECT TỪ DƯỚI FORM LÊN CONTROLLER. 
	//NẾU DÙNG @RequestParam THÌ KHÔNG SỬ DỤNG ĐƯỢC KĨ THUẬT VALIDATION NÀY 
	
	// CHẶN ĐẦU, CHẶN ĐUÔI QUÁ TRÌNH BINDING DŨ LIỆU TỪ DƯỠI FORM LÊN OBJECT
	//CHẶN ĐẦY QUA @Valid ĐỂ KÍCH HOẠT VIỆC KIỂM SOÁT TỪN FIELD ĐC GÁN GIÁ TRỊ CÓ BỊ LỖI HAY KO.NẾU PHÁT HIỆN LỖI, THÌ
	//GHI BIÊN BẢN QUA BindingResult
	//BIÊN BẢN VI PHẠM RESULT TỰ ĐC ADD VÀO THÙNG MODEL GỬI TRỞ LẠI FORM
	@PostMapping("/save-product")
	public ResponseEntity<?> save(@Valid @ModelAttribute ProductDTO productDTO, BindingResult bindingResult) {
		
		//NẾU CÓ LỖI TRONG QUÁ TRÌNH BINDING THÌ QUAY LẠI MÀN HÌNH NHẬP
		
		productService.save(productDTO);
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.header("location", "/result")
				.build();
	}
}
