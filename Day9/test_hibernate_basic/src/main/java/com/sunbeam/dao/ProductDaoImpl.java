package com.sunbeam.dao;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

public class ProductDaoImpl implements ProductDao{
	
	@Override
	public String addProduct(Products product) {
		String msg = "Adding Product Failed!!!";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();	
		try{
			Serializable productId = session.save(product);
			tx.commit();
			msg="Product Added Successfully, with ID - "+productId;
		}	catch(RuntimeException e) {
				if(tx != null)
					tx.rollback();
				throw e;
		}	
		return msg;
	}

	@Override
	public Products getProducts(Long productId) {
		Products product = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product = session.get(Products.class, productId);
			product = session.get(Products.class, productId);
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		
		return product;
	}

	@Override
	public List<Products> getProductsByCategoryAndPriceRange(double start, double end, Category category) {
		List<Products> list = null;
		String jpql = "select p from Products p where p.price between :start and :end and p.category=:cat";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			list = session.createQuery(jpql, Products.class)
					.setParameter("start", start)
					.setParameter("end", end)
					.setParameter("cat", category)
					.getResultList();
			
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return list;
	}

	@Override
	public String discoutedProductsByCategory(Double discountPrice,Category category) {
		String msg="Applying Discount Failed!";
		String jpql="update Products p set price= price - :discPrice where category = :cat";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int count = session.createQuery(jpql).setParameter("discPrice", discountPrice).setParameter("cat", category).executeUpdate();
			tx.commit();
			msg = "Discount applied to "+count+" users";
		}catch(RuntimeException e){
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String PurchaseProduct(int quantity, Long productid) {
		String msg = "Product purchase Failed!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Products product= session.get(Products.class, productid); 
			if(product != null) {
				if(product.getAvailableQuantity()>=quantity) {
				product.setAvailableQuantity(product.getAvailableQuantity()-quantity);
				msg = "Product Purchased Successfully!!!";
				}else {
					msg="Insufficient Quantity!!";
				}
			}else {
				msg = "Invalid Id!!!";
			}
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null)
				tx.rollback();
			throw e;
		}		
		return msg;
	}

	@Override
	public String DeleteProduct(String productName) {
		String msg = "Product Deletion Failed!";
		String jpql = "select p from Products p where p.productName = :productName";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Products product = session.createQuery(jpql,Products.class).setParameter("productName", productName).getSingleResult();
			session.delete(product);
			tx.commit();
			msg = "Product Deleted !!";
		}catch(RuntimeException e){
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
}
