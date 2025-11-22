package com.jone.superapp.fap_student_layered.repository;

import java.util.List;

import com.jone.superapp.fap_student_layered.entity.Student;
import com.jone.superapp.fap_student_layered.infra.JpaUtil;

import jakarta.persistence.EntityManager;

public class StudentRepository {
	//CLASS NÀY CHỨA CÁC HÀM TRỰC TIẾP TABLE STUDENT - REPO: NHÀ KHO VỀ DỮ LIỆU 
	//MUỐN CRUD TABLE THÌ PHẢI NHỜ VÀ ÔNG ENTITY-MANAGER ĐƯỢC CUNG CẤP TỪ JpaUtil SINGLETON
	//Flow: UI --- SERVICE --- REPO --- JpaUtil(ENTITY - MANAGER VÀ FACTORY) --- TABLE
	
	//NẾU CÓ THAY ĐỔI TRONG TABLE THÌ  HÀM SẼ NHẬN VÀO OBJECT HOẶC KEY. DELETE ĐƯA OBJECT VẪN ĐƯỢC VID VÀO TRONG OBJECT, GET FIELD KEY ĐỂ XÓA.
	
	public List<Student> getAllStudents() {
		EntityManager entityManager = JpaUtil.getEntityManager();
		List<Student> result = entityManager.createQuery("FROM Student s", Student.class).getResultList();
		return result;
	}
	
	public void insertStudent(Student student) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void deleteStudent(String id) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void update(Student st) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();
		Student student = new Student();
		entityManager.merge(student);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
