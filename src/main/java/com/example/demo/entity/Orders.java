package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="order_date")
	private Date orderDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users users;
	
	@ManyToMany
	@JoinTable(name = "order_products",
	joinColumns = @JoinColumn(name ="order_id"),
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products = new ArrayList<Product>();
}
