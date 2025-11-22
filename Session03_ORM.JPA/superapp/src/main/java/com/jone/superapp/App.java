package com.jone.superapp;

import java.util.List;

import com.jone.superapp.entity.Lecturer;
import com.jone.superapp.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.jone.superapp-PU");
    public static void main(String[] args) {
        //insertStudent();// TẠO BẢNG, CHÈN DATA QUA OOP, CODE FIRST
        //getAllStudents(); // SELECT DỮ LIỆU
    	//searchLecturers();
    	//findById();
    	//remove();
    	update();
    	findById();
    }
    
    public static void insertStudent() {
    	//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.jone.superapp-PU");//GỬI THÔNG SỐ CẤU HÌNH SERVER, NHÀ THẦU JPA: HIBERNATE, NHÀ THẦU JDBC CHO JPA CLASS 
    	//LO ĐỂ TẠO KẾT NỐI TỚI CSDL CỤ THỂ LÀ SQL SERVER.
    	
    	EntityManager entityManager = entityManagerFactory.createEntityManager();//TẠO RA MỘT OBJECT DÙNG ĐỂ QUẢN LÝ CÁC ENTITY CLASS ~ MAP 1:1 VỚI TABLE. CLASS Student chịu sự quản lí của EntityManager(entityManager)
        //entityManager sẽ lo CRUD trên 1 table nào đó qua các hàm: persist(),merge(),find(), remove()
    	//TOÀN CHƠI OBJECT , đằng sau là table bị ảnh hưởng, tự sinh sql ngầm và nó cho mình thấy khi chấm(.) các hàm ở trên.
    	//CHUẨN BỊ DATA OBJECT
    	Student an = new Student("SE4", "Lan Đinh", 2004, 8.6);
    	Student binh = new Student("SE5", "Mai Anh", 2002, 7.6);
    	Student cuong = new Student("SE6", "Dương Hoàng", 2000, 8.2);
    	
    	entityManager.getTransaction().begin();
    	entityManager.persist(an);// CREATE TABLE DIỄN RA NGẦM
    	entityManager.persist(binh); //GỌI LÀ CODE FIRST, CODE RA TABLE
    	entityManager.persist(cuong); //CODE RA DATA
    	                              // INSERT INTO STUDENT VALUES()
    	entityManager.getTransaction().commit();//HOẶC CẢ 3 INSERT THÀNH CÔNG, HOẶC KHÔNG GÌ CẢ
        entityManager.close();// CHO CÚT VÌ DÙNG XONG RỒI
        //entityManagerFactory.close();// CŨNG CÚT NỐT NGẮT KẾT NỐI CSDL VÌ ĐÃ XONG
    }
    
    public static void getAllStudents() {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	List<Student> reList = entityManager.createQuery("FROM Student", Student.class).getResultList();
    	System.out.println("danh sach");
    	for(Student item : reList) {
    		System.out.println(item);
    	}
    	entityManager.close();
    	entityManagerFactory.close();
    }   
    
    public static void insertLecturers() {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	//Vì có thay đổi trên csdl nên cần theo dõi chặt chẽ các câu lệnh -> dùng khái niệm transaction: DO ALL OR NOTHING
    	//Hoặc tất cả hoặc không gì cả.Nguyên lý ACID của transaction
    	entityManager.getTransaction().begin();
    	Lecturer hoang = new Lecturer("Hà Nguyễn", 1990, 20_000_000);
    	Lecturer van = new Lecturer("Vân Mai", 1990, 21_000_000);
    	entityManager.persist(hoang);
    	entityManager.persist(van);
    	entityManager.getTransaction().commit();
    	entityManager.close();
    }
    
    public static void getAllLecturers() {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	//Viết câu SQL style object, gọi là JPQL, HQL khá giống sql truyền thống, nhưng là làm việc, select, thao tác trên object, trên cái class Entity chứ không quan tâm tên cột trong table dưới database
    	List<Lecturer> result = entityManager.createQuery("FROM Lecturer", Lecturer.class).getResultList();//Lecturer là class, từ đó sinh ra object, class Lecturer đã được map thành
    	                                                                                                   // table ở bên khai báo @Entity
    	System.out.println("danh sach:");
//    	for(Lecturer item : result) {
//    		System.out.println(item);
//    	}
    	result.forEach((Lecturer lt) -> {
    		System.out.println(lt);
    	});
    	entityManager.close();
    	entityManagerFactory.close();
    }
    
    //JPQL : JAVA PERSISTENCE QUERY LANGUAGE
    //LÀ PHIÊN BẢN ĐỘ TỪ SQL NHƯNG DÀNH CHO GIỚI OOP, OBJECT
    //HIBERNATE CŨNG CÓ PHIÊN BẢN RIÊNG CỦA NÓ GỌI LÀ HQL
    // SQL: SELECT *FROM LECTURER
    // JPQL: FROM LECTURER
    //       SELECT lec FROM LECTURER lec
    // với mỗi dòng/record lấy từ table Lecturer ta new nó trong RAM, new Lecturer() và gọi vùng new này là lec, tức là lec = new Lecturer()
    //và lặp lại cho toàn bộ record trong table Lecturer
    // ADD kết quả đọc từ table vào kết quả cuối dùng lệnh SELECT lec
    //SELECT lec tức là lấy từng object lec được new từ từng dòng trong table Lecturer
 

    public static void searchLecturers() {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	//List<Lecturer> result = entityManager.createQuery("SELECT l FROM Lecturer l WHERE l.salary = ?1", Lecturer.class).setParameter(1, 20000000).getResultList();
    	List<Lecturer> result = entityManager.createQuery("SELECT l FROM Lecturer l WHERE l.salary = :pSalary", Lecturer.class).setParameter("pSalary", 20000000).getResultList();
        System.out.println("danh sách giảng viên có lương 20000000");
        result.forEach((Lecturer lt) -> {
        	System.out.println(lt);
        });
    }
    
    public static void findById() {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	Lecturer lec = entityManager.find(Lecturer.class, 4);
    	Student student = entityManager.find(Student.class, "SE5");
        System.out.println(lec);
        System.out.println(student);
    }
    
    public static void remove() {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	entityManager.getTransaction().begin();
    	Lecturer lec = entityManager.find(Lecturer.class, 1);
    	Student student = entityManager.find(Student.class, "SE4");
    	entityManager.remove(lec);
    	entityManager.remove(student);
    	entityManager.getTransaction().commit();
        System.out.println("xóa thành công");
    }
    
    public static void update() {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	entityManager.getTransaction().begin();
    	Lecturer lec = entityManager.find(Lecturer.class, 4);
    	Student student = entityManager.find(Student.class, "SE5");
    	lec.setSalary(25000000);
    	student.setGpa(9.3);
    	entityManager.getTransaction().commit();
    	System.out.println("cập nhật thành công");
    }
}
