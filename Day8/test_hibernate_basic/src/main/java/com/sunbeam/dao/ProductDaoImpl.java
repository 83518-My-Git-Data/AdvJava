package com.sunbeam.dao;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

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
}
