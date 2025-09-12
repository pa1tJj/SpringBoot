package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Users;
import com.example.demo.model.OrderDTO;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.OrderService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
	private UsersRepository usersRepository;
	private OrderRepository orderRepository;

	@Override
	public void addOrUpdate(OrderDTO orderDTO) {
		Orders orders = new Orders();
		orders.setId(orderDTO.getId());
		orders.setOrderDate(orderDTO.getOrderDate());
		Users users = usersRepository.findById(orderDTO.getUserId()).get();
		orders.setUsers(users);
		orderRepository.save(orders);
	}

}
