package com.jsp.foodapp.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.entites.Admin;



@Repository
public class AdminDao {

	@Autowired
	EntityManagerFactory factory;

	public void saveAdmin(Admin admin) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(admin);
		transaction.commit();
	}

	public void updateAdmin(Admin admin) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(admin);
		transaction.commit();
	}

	public void deleteAdmin(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Admin admin = manager.find(Admin.class, id);
		transaction.begin();
		manager.remove(admin);
		transaction.commit();
	}

	public List<Admin> viewAllAdmin() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select a from Admin a");
		List<Admin> admins = query.getResultList();
		return admins;
	}

	public Admin login(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select a from Admin a where a.email = ?1 and a.password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Admin> admins = query.getResultList();
		if (admins.size() > 0)
			return admins.get(0);
		else
			return null;
	}

}
