package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {
	private Long id;
	private Date orderDate;
	private Long userId;

}
