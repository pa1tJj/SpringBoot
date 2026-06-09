package com.jonet.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonet.demo.entity.DataRows;

public interface DataRowRepository extends JpaRepository<DataRows, UUID>{

}
