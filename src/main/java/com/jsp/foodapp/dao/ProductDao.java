package com.jsp.foodapp.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entites.Product;


@Repository
public class ProductDao {

	@Autowired
	EntityManagerFactory factory;

	public void saveProduct(Product product) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(product);
		transaction.commit();
	}

	public void updateProduct(Product product) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(product);
		transaction.commit();
	}

	public void deleteProdctById(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Product product = manager.find(Product.class, id);
		transaction.begin();
		manager.remove(product);
		transaction.commit();
	}

	public List<Product> viewAllProduct() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select p from Product p");
		List<Product> products = query.getResultList();
		return products;
	}

	public Product viewProductById(int id) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(Product.class, id);
	}

}