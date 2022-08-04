package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Cart;
import com.spring.model.Shoes;
import com.spring.repository.CartRepository;
import com.spring.repository.ShoeRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository crepo;
	
	
	public void addcart(Shoes shoes,int qty, int productId)
	{
		List<Cart> cartlist = cartList();
		Cart cart = new Cart();
		
		int cartid = 0;
		if(cartlist.size()==0)
		{
			
			shoes.setQuantity(qty);
			shoes.setTotalprice(shoes.getPrice()*qty);
			cart.setShoes(shoes);	
			crepo.save(cart);
		}
		else
		{
		
		
		int totalqty = 0;
		
		for(Cart s: cartlist)
		{
			if(s.getShoes().getProductId()==productId)
			{
				totalqty = qty+shoes.getQuantity();
				shoes.setQuantity(totalqty);
				shoes.setTotalprice(totalqty*shoes.getPrice());
				cartid = s.getCartId();
				cart.setCartId(cartid);
				
			}
			else
			{
				shoes.setTotalprice(shoes.getPrice()*qty);
				shoes.setQuantity(qty);
			}
		}
	
		cart.setShoes(shoes);	
		crepo.save(cart);
		}
		
		
		
	}
	

	
	
	public List<Cart> cartList()
	{
		return crepo.findAll();
		
	}
	
	public List<Shoes> cartshoes()
	{
		List<Cart> cart = cartList();
		List<Shoes> shoes = new ArrayList<>();
		
		
		for(Cart c: cart)
		{
			shoes.add(c.getShoes());
		}
		return shoes;
		
	}
	
	public Shoes getbyShoes(int id)
	{
		Shoes shoes = null;
		List<Cart> cart = cartList();
		for(Cart c:cart)
		{
			if(c.getShoes().getProductId()==id)
			{
				shoes = c.getShoes();
			}
			
		}
		return shoes;
		
		
	}
	
	public void delete()
	{
		crepo.deleteAll();
	}
	
	
}
