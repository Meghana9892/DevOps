package com.spring.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Cart;

import com.spring.model.Shoes;
import com.spring.model.User;
import com.spring.model.Purchase;
import com.spring.repository.PurchaseRepository;


@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository prepo;
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private ShoeService shoeservice;
	
	
	public void buynow(List<Shoes> shoes)
	{
		
		Purchase purchase = new Purchase();
		List<Shoes> shoelist = new ArrayList<>();
		for(Shoes s:shoes)
		{
			shoelist.add(s);
		}
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate= formatter.format(date);  
		purchase.setPurchasedate(strDate);
		purchase.setShoes(shoelist);
		
		prepo.saveAndFlush(purchase);
		
	}
	
	public List<Purchase> getPurchase()
	{
		return prepo.findAll();
	}
	
	public List<Shoes> getpurchaseshoes(int id)
	{
		List<Purchase> purchase = prepo.findAll();
		
		List<Shoes> shoes = new ArrayList<>();
		
		for(Purchase p: purchase)
		{
			if(p.getPurchaseid()==id)
			{
				for(Shoes s : p.getShoes())
				{
					shoes.add(s);
				}
			}
		}
		return shoes;
	}

	}

