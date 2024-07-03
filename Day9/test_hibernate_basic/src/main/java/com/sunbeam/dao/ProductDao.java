package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

public interface ProductDao {
	String addProduct(Products product);
	Products getProducts(Long productId);
	List<Products> getProductsByCategoryAndPriceRange(double start, double end, Category category);
	String discoutedProductsByCategory(Double discountPrice, Category category);
	String PurchaseProduct(int quantity, Long productid);
	String DeleteProduct(String productName);
	
}
