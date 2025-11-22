package com.jone.uploadfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jone.uploadfile.entity.Picture;

public interface PicRepository extends JpaRepository<Picture, Long>{

}
