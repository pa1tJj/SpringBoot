package com.jone.javweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jone.javweb.model.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	Page<Movie> findByNameContaining(String name, Pageable pageable);
	Page<Movie> findByGenreId(Long genreId, Pageable pageable);
	Page<Movie> findByNameContainingAndGenreId(String name, Long genreId, Pageable pageable);
}
