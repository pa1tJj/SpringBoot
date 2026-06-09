package com.jonet.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonet.demo.entity.ExcelTemplate;

public interface ExcelTemplateRepository extends JpaRepository<ExcelTemplate, UUID>{
	ExcelTemplate findByCode(String code);
}
