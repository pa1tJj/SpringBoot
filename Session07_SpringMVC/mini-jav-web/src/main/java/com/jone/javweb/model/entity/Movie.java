package com.jone.javweb.model.entity;

import java.util.ArrayList;
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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
public class Movie {

	public Movie(String name, String duration, String image, Long episodes, String detail, Genre genre,
			List<Actor> actors) {
		super();
		this.name = name;
		this.duration = duration;
		this.image = image;
		this.episodes = episodes;
		this.detail = detail;
		this.genre = genre;
		this.actors = actors;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", columnDefinition = "NVARCHAR(MAX)")
	private String name;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "episodes")
	private Long episodes;
	
	@Column(name = "detail", columnDefinition = "NVARCHAR(MAX)")
	private String detail;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	@ManyToMany
	@JoinTable(name = "actor_movie",
	joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private List<Actor> actors = new ArrayList<Actor>();
}
