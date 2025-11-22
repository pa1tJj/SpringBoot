package com.jone.javweb.converter;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.jone.javweb.model.dto.ActorDTO;
import com.jone.javweb.model.dto.GenreDTO;
import com.jone.javweb.model.dto.MovieDTO;
import com.jone.javweb.model.entity.Actor;
import com.jone.javweb.model.entity.Genre;
import com.jone.javweb.model.entity.Movie;
import com.jone.javweb.model.response.MovieResponse;

@Component
public class Converter {

	private final ModelMapper mapper;
	
	public Converter(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public Movie toMovieEntity(MovieDTO movieDTO) {
		Movie movie = mapper.map(movieDTO, Movie.class);
		return movie;
	}
	
	public Actor toActorEntity(ActorDTO actorDTO) {
		return mapper.map(actorDTO, Actor.class);
	}
	
	public Genre toGenreEntity(GenreDTO genreDTO) {
		return mapper.map(genreDTO, Genre.class);
	}
	
	public MovieDTO toMovieDTO(Movie movie) {
		MovieDTO movieDTO = mapper.map(movie, MovieDTO.class);
		String actor = "";
		List<Actor> a = movie.getActors();
		for(Actor item : movie.getActors()) {
			actor += item.getName() + ",";
 		}
		movieDTO.setActor(actor);
		return movieDTO;
	}
	
	public MovieResponse toMovieResponse(Movie movie) {
		MovieResponse movieResponse = mapper.map(movie, MovieResponse.class);
		String actor = "";
		List<Actor> a = movie.getActors();
		for(Actor item : movie.getActors()) {
			actor += item.getName() + ",";
 		}
		movieResponse.setActor(actor);
		return movieResponse;
	}
}
