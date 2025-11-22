package com.jone.superapp.student_manager_otm_mto_mtm.entity.unione;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@Column(name = "id", columnDefinition = "CHAR(8)")
	private String id;
	
	@Column(name = "name", columnDefinition = "NVARCHAR(50)")
	private String name;
	
	@Column(name = "yob", nullable = false)
	private int yob;
	
	@Column(name = "gpa")
	private double gpa;
	
	//CÁC OBJECT CÓ MỐI QUAN HỆ
	//STUDENT THAM CHIẾU ĐẾN THÔNG TIN MAJOR - OBJECT
	//CÓ CÁCH ĐỂ CONVERT TÙE OOP THÀNH TABLE/FK, JOIN COLUMN -> ORM MAPPING
	//CẦN 1 THẰNG GIÚP ÁNH XẠ 2 THẾ GIỚI ĐỂ CHO TƯƠNG THÍCH: JPA/HIBERNATE
}

