package com.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.spring.model.Shoes;
import com.spring.repository.ShoeRepository;

@Service
public class ShoeService {

	@Autowired
	private ShoeRepository srepo;
	
	public void addshoes(Shoes shoes)
	{
		shoes.setQuantity(0);
		shoes.setTotalprice(0);
		srepo.save(shoes);
	}
	
	public List<Shoes> getshoes()
	{
		return srepo.findAll();
		
		
	}
	
	public Shoes getShoesById(int Id)
	{
	 Optional<Shoes> shoesresponse = srepo.findById(Id);
	 Shoes shoes = shoesresponse.get();
	 return shoes;
	 
	}
	
	public boolean validate(int productId)
	{
		boolean result=false;
		
		List<Shoes> shoes = srepo.findAll();
		
		
		for(Shoes s:shoes)
		{
			if(s.getProductId()==productId)
			{
				result = true;
			}
		}
		return result;
	}
	
	public void setqtyprice()
	{
		
		List<Shoes> shoeslist= getshoes();
		
		
		for(Shoes s:shoeslist)
		{
			s.setQuantity(0);
			s.setTotalprice(0);
			srepo.save(s);
		}
		
	}
	
	public List<Shoes> sortByProductName()
	{
		
		List<Shoes> shoes = srepo.findAll(Sort.by(Sort.Direction.ASC, "brand"));
		
		
		return shoes;
	}
}
