package com.jone.mvnp.mvnp_master_data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor       //constructor không tham số
@AllArgsConstructor     //constructor full tham số
@Getter
@Setter
@ToString
public class Student {

	private String id;
	private String name;
	private int yob;
	private double gpa;
	
	
}
