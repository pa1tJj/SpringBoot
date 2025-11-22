package com.jone.superapp.student_manager_otm_mto_mtm.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	private JpaUtil() {}
	
	private static class EntityManagerFactoryHelper {
		private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.jone.superapp-PU");
	}
	
	public static EntityManager getEntityManager() {
		return EntityManagerFactoryHelper.entityManagerFactory.createEntityManager();
	}
}
