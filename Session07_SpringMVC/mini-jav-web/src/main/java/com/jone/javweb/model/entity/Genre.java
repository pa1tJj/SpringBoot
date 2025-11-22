package com.jone.javweb.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "genre")
@Data
@NoArgsConstructor
public class Genre {

	public Genre(String name) {
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "genre", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Movie> movies = new ArrayList<Movie>();
	
}
