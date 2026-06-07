package com.jonet.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonet.demo.entity.BatchEntity;

public interface BatchRepository extends JpaRepository<BatchEntity, UUID> {

}
