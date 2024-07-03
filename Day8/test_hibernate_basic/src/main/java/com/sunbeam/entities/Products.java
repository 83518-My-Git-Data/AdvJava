package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Category category;
	@Column(name="product_name" , length=25, unique=true)
	private String productName;
	private double price;
	@Column(name="avail_qty")
	private int availableQuantity;
	
	public Products() {}
	
	public Products(Category category, String productName, double price, int availableQuantity) {
		super();
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", category=" + category + ", productName=" + productName + ", price=" + price
				+ ", availableQuantity=" + availableQuantity + "]";
	}	
}
