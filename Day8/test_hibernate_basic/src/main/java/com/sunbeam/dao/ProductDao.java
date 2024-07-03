package com.sunbeam.dao;

import com.sunbeam.entities.Products;

public interface ProductDao {
	String addProduct(Products product);
	Products getProducts(Long productId);
}
