package com.spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int purchaseid;
	
	private String purchasedate;
	
	

	public String getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Shoes> shoes = new ArrayList<>();
	

	

	public int getPurchaseid() {
		return purchaseid;
	}

	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}

	public List<Shoes> getShoes() {
		return shoes;
	}

	public void setShoes(List<Shoes> shoes) {
		this.shoes = shoes;
	}

	
	
	
}
