package com.jsp.foodapp.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entites.User;



@Repository
public class UserDao {

	@Autowired
	EntityManagerFactory factory;

	public void saveUser(User user) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}

	public void updateUser(User user) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(user);
		transaction.commit();
	}

	public void deleteUserById(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		User user = manager.find(User.class, id);
		transaction.begin();
		manager.remove(user);
		transaction.commit();
	}

	public List<User> viewAllUser() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select u from User u");
		List<User> users = query.getResultList();
		return users;
	}

	public User login(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select a from User a where a.email = ?1 and a.password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

}