package com.jone.javweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jone.javweb.converter.Converter;
import com.jone.javweb.model.entity.Genre;
import com.jone.javweb.repository.GenreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreService {

	private final GenreRepository genreRepository;
	private final Converter converter;
	
	public void save(Genre genre) {
		genreRepository.save(genre);
	}
	
	public List<Genre> findAll() {
		return genreRepository.findAll();		
	}
}
