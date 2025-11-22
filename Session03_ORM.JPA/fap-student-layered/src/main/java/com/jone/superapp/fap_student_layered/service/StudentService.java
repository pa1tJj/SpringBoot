package com.jone.superapp.fap_student_layered.service;

import java.util.List;

import com.jone.superapp.fap_student_layered.entity.Student;
import com.jone.superapp.fap_student_layered.repository.StudentRepository;

public class StudentService {
	
	//CLASS NÀY ĐỨNG GIỮA, HỨNG INFO TỪ USER/NGƯỜI DÙNG, TẠO OBJECT, ĐẨY XUỐNG CHO REPO LO GIÚP
	//NÓ CŨNG NHỜ REPO LẤY OBJECT TỪ TABLE, ĐẨY NGƯỢC LÊN UI CHO USER XEM
	//CHẮC CHẮN NÓ PHẢI KHAI BÁO BIẾN REPO ĐỂ REPO GIÚP
	//CHỈ CẦN 1 BIẾN REPO DÙNG CHUNG CHO CÁC HÀM, DO MÌNH GỌI BÊN TRONG REPO
	// .save(), findAll()...
	
	//CLASS NÀY PHẢI CHUẨN BỊ OBJECT ĐỂ ĐƯA XUÓNG REPO
	
	private StudentRepository studentRepository = new StudentRepository();
	
	public List<Student> getAllStudents(){
		List<Student> result = studentRepository.getAllStudents();
		return result;
	}
	
	public void insertStudent(Student student) {
		studentRepository.insertStudent(student);
	}
	
	public void deleteStudent(String id) {
		studentRepository.deleteStudent(id);
		System.out.println("delete successfully!");
	}
	
	public void updateStudent(Student student) {
		studentRepository.update(student);
		System.out.println("update successfully!");
	}
}
