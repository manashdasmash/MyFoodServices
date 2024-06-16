package com.jsp.foodapp.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entites.Item;



@Repository
public class ItemDao {
	@Autowired
	EntityManagerFactory factory;

	public void saveItem(Item item) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(item);
		transaction.commit();
	}

	public void updateItem(Item item) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(item);
		transaction.commit();
	}

	public void deleteItemById(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Item item = manager.find(Item.class, id);
		transaction.begin();
		manager.remove(item);
		transaction.commit();
	}

	public List<Item> viewAllItem() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select l from Item l");
		List<Item> items = query.getResultList();
		return items;
	}

	public Item viewItemById(int id) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(Item.class, id);
	}
}
