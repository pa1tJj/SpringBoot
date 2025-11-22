package com.jone.coffee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {
	
	public Product(String name, Long quantity, Long price, Category category) {
		this.name = name; 
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", columnDefinition = "NVARCHAR(100)", nullable = false)
	private String name;
	
	@Column(name = "quantity", nullable = false)
	private Long quantity;
	
	@Column(name = "price", nullable = false)
	private Long price;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
}
