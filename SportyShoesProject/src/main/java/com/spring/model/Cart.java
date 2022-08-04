package com.spring.model;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;

	
	@ManyToOne(fetch = FetchType.EAGER)
	private Shoes shoes;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	

	public Shoes getShoes() {
		return shoes;
	}

	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}
	
	

	
	
}
