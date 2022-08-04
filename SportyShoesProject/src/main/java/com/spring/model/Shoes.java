package com.spring.model;

import javax.persistence.*;

@Entity
public class Shoes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	
	public String brand;
	private int size;
	private int price;
	
	@Column(nullable = true)
	private int quantity;
	
	@Column(nullable = true)
	private int totalprice;
	
	

	public Shoes() {
		super();
	}
	


	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getTotalprice() {
		return totalprice;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}



	public Shoes(int productId, String brand, int size, int price) {
		super();
		this.productId = productId;
		brand = brand;
		this.size = size;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
