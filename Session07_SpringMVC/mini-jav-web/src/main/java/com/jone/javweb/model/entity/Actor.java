package com.jone.javweb.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "actor")
@Data
@NoArgsConstructor
public class Actor {
	
    public Actor(String name, Long age, String body) {
    	this.name = name;
    	this.age = age;
    	this.body = body;
    }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Long age;
	
	@Column(name = "body")
	private String body;
	
	@ManyToMany(mappedBy = "actors")
	private List<Movie> movies = new ArrayList<Movie>();
}
