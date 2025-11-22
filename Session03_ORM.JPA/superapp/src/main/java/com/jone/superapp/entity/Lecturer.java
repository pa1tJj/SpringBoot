package com.jone.superapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity// ánh xạ class này thành một table tương ứng số cột, số field
@Table(name = "lecturer")
@Data
@NoArgsConstructor
public class Lecturer {
	public Lecturer(String name, int yob, int salary) {
		this.name = name;
		this.yob = yob;
		this.salary = salary;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", columnDefinition = "NVARCHAR(50)", nullable = false)
	private String name;
	
	@Column(name = "yob")
	private int yob;
	
	@Column(name = "salary")
	private double salary;
}
