package com.jonet.demo.entity;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "template")
@Getter
@Setter
public class ExcelTemplate {
	
	@Id
	@GeneratedValue
	@UuidGenerator
	private UUID id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "entityName")
	private String entityName;
	
	@OneToMany(mappedBy = "template", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<ExcelMapping> mappings;
}
