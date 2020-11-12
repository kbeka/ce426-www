/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;


/**
 *
 * @author cleob
 */

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.*;
import com.example.web.*;
import com.example.util.*;


public class Dao {
	
	/**
	 * Save Product
	 * @param p
	 */
	public void saveProduct(Products p) {
		Transaction transaction = null;
		try (Session session = Hibernate.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the product object
			session.save(p);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Update Product
	 * @param p
	 */
	public void updateProduct(Products p) {
		Transaction transaction = null;
		try (Session session = Hibernate.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the product object
			session.update(p);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Delete User
	 * @param code
	 */
	public void deleteProduct(int code) {

		Transaction transaction = null;
		try (Session session = Hibernate.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Products p = session.get(Products.class, code);
			if (p != null) {
				session.delete(p);
				System.out.println("product is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Get Product By barcode
	 * @param code
	 * @return
	 */
	public Products getBarcode(String code) {

		Transaction transaction = null;
		Products user = null;
		try (Session session = Hibernate.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an product object
			user = session.get(Products.class, code);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return user;
	}
	
	/**
	 * Get all Products
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Products> getAllProducts() {

		Transaction transaction = null;
		List<Products> listOfProducts = null;
		try (Session session = Hibernate.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			listOfProducts = session.createQuery("from Products").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
                        e.printStackTrace();
		}
		return listOfProducts;
	}
}
