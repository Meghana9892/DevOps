package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Shoes;
import com.spring.model.User;
import com.spring.service.ShoeService;

@Controller
public class ShoeController {

	@Autowired
	private ShoeService shoeservice;

	@RequestMapping(value= "/shoe", method= RequestMethod.GET)
	public String showshoePage(@ModelAttribute("shoe")Shoes shoes,BindingResult result)
	{
		
		return "addshoe";
		
	}
	

	@RequestMapping(value= "/products", method= RequestMethod.GET)
	public String showProductsPage(@ModelAttribute("shoe")Shoes shoes,BindingResult result,Model model)
	{
		List<Shoes> shoelist = shoeservice.getshoes();
		
		model.addAttribute("shoes",shoelist);
		
		return "products";
		
	}
	
	@RequestMapping(value= "/sort", method= RequestMethod.POST)
	public String sortProductsPage(@ModelAttribute("shoe")Shoes shoes,BindingResult result,Model model)
	{
		List<Shoes> shoelist = shoeservice.sortByProductName();
		
		model.addAttribute("shoes",shoelist);
		model.addAttribute("message", "Sorted by Asc");
		
		return "products";
		
	}
	
	@RequestMapping(value= "/addshoe", method= RequestMethod.POST)
	public String showLoginPage(@ModelAttribute("shoe")Shoes shoes,BindingResult result,Model model)
	{
		shoeservice.addshoes(shoes);
		model.addAttribute("message", "Product Added");
		return "addshoe";
		
	}
	
}
