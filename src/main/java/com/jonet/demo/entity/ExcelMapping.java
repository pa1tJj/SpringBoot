package com.jonet.demo.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mapping")
@Getter
@Setter
public class ExcelMapping {
	@Id
	@GeneratedValue
	@UuidGenerator
    private UUID id;

	@Column(name = "templateCode")
    private String templateCode;

	@Column(name = "excelColumn")
    private String excelColumn;

	@Column(name = "fieldName")
    private String fieldName;

	@Column(name = "columnIndex")
    private Integer columnIndex;

	@Column(name = "dataType")
    private String dataType;

	@Column(name = "required")
    private Boolean required;

	@Column(name = "visible")
    private Boolean visible;

	@Column(name = "sortOrder")
    private Integer sortOrder;
	
	@Column(name = "headerName")
	private String headerName;
    
    @ManyToOne
    @JoinColumn(name = "template_id")
    private ExcelTemplate template;
}
