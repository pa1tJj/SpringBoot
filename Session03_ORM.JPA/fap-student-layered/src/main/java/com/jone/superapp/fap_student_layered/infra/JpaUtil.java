package com.jone.superapp.fap_student_layered.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
//Class này chịu trách nhiệm kết nối csdl thông qua đối tượng entity- manager-factory, hao RAM, tốn thời gian để tạo kênh kết nối với SQL SERVER/MYSQL -> Heavy class
//Nó nên được khởi tạo sớm, 1 lần, 1 instancce, 1 vùng RAM, 1 OBJECT
//Chưa kêt mỗi lần nó tạo ra, có khi nó sẽ được tạo mới table luôn(OPTION, CREATE TRONG XML) HOẶC NÓ SCAN LẠI CẤU TRÚC TABLE CÓ THAY ĐỔI GID KHÔNG ĐỂ CẬP NHÂT (OPTION UPDATE TRONG .XML)
//CLASS NÀY GỌI NHIỀU LẦN THÌ CŨNG CHỈ CÓ 1 VÙNG NEW ĐƯỢC TẠO RA
//STATIC + CONSTRUCTOR
//1 CLASS KHÔNG CÓ CONSTRUCTOR THÌ JVM SẼ TỰ TẠO 1 CONSTRUCTOR RỖNG, VẪN NEW ĐƯỢC
public class JpaUtil {
	private JpaUtil() {}
	
	private static class EntityManagerFactoryHelper { //HÀM duy trì kết nối tới CSDL, đọc file persistence.xml để tạo dựng/update table heavy load nằm ở biến này
		private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.jone.superapp-PU");
	}
	
	public static EntityManager getEntityManager() {
		return EntityManagerFactoryHelper.entityManagerFactory.createEntityManager();
	}
	
	public static void close() {
		EntityManagerFactoryHelper.entityManagerFactory.close();
	}
}
