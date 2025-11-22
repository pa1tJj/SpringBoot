package com.jone.superapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//CLASS NÀY SẼ ĐƯỢC KHAI BÁO ÁNH XẠ/BIẾN ĐỔI TƯƠNG ĐƯƠNG, MAP THÀNH TABLE TƯƠNG ỨNG

@Entity
@Table(name = "Student")//NẾU KHÔNG CÓ KHAI BÁO NÀY THÌ MẶC ĐỊNH CLASS THÀNH TÊN TABLE
@Data
public class Student {
	
	@Id
	@Column(name = "id", columnDefinition = "CHAR(8)")//nếu không có khai báo này thì mặc định lấy tên biến, field làm tên cột
	private String id;
	
	@Column(name = "name", nullable =  false, length = 50, columnDefinition = "NVARCHAR(50)")
	//dùng @Nationalized sẽ mất đi tính dùng lại/mở rộng khi code này sẽ không thể chơi được với kiểu khác Hibernate như eclipselink
	//@Nationalized //THIẾU KHAI BÁO NÀY THÌ STRING -> VARCHAR, KHÔNG LƯU ĐƯỢC TIẾNG VIỆT CÓ DẤU
	
	private String name;
	
	@Column(name = "yob", nullable = false)
	private int yob;
	
	@Column(name = "gpa")
	private double gpa;
	
	//BẮT BUỘC PHẢI CÓ CONSTRUCTOR RỖNG, HOẶC CÓ FULL THAM SỐ
	public Student(String id, String name, int yob, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.yob = yob;
		this.gpa = gpa;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", yob=" + yob + ", gpa=" + gpa + "]";
	}
	

	
	
}
