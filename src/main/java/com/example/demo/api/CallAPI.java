package com.example.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.OrderDTO;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/test")
public class CallAPI {
	
	private OrderService orderService;
	private UserService userService;
	
	@PostMapping("/order")
	public ResponseEntity<?> addOrUpdate(@RequestBody OrderDTO orderDTO) {
		orderService.addOrUpdate(orderDTO);
		return ResponseEntity.ok("thêm thành công");
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteUser(@RequestParam Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("xóa thành công");
	}
}
