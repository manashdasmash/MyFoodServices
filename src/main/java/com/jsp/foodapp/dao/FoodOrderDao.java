package com.jsp.foodapp.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entites.FoodOrder;



@Repository
public class FoodOrderDao {
	@Autowired
	EntityManagerFactory factory;

	public void saveFoodOrder(FoodOrder order) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(order);
		transaction.commit();
	}

	public void updateFoodOrder(FoodOrder order) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(order);
		transaction.commit();
	}

	public void deleteFoodOrderById(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		FoodOrder order = manager.find(FoodOrder.class, id);
		transaction.begin();
		manager.remove(order);
		transaction.commit();
	}

	public List<FoodOrder> viewAllFoodOrder() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select f from FoodOrder f");
		List<FoodOrder> orders = query.getResultList();
		return orders;
	}

	public FoodOrder viewFoodOrderById(int id) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(FoodOrder.class, id);
	}

}
