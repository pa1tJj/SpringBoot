package com.jone.javweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jone.javweb.model.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}
