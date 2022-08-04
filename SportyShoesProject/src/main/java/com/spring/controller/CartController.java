package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.spring.model.*;

import com.spring.service.CartService;
import com.spring.service.ShoeService;

@Controller
public class CartController {

	@Autowired
	private CartService cartservice;
	
	@Autowired
	private ShoeService shoeservice;
	
	
	@RequestMapping(value= "/addcart", method= RequestMethod.POST)
	public String addcartPage(@ModelAttribute("cart")Shoes shoes,BindingResult result, Model model)
	{
		int productId = shoes.getProductId();
		int quantity = shoes.getQuantity();
		
		List<Shoes> shoelist = shoeservice.getshoes();
		model.addAttribute("shoes",shoelist);
		
		
		boolean output = shoeservice.validate(productId);
		
		if(output)
		{
		Shoes shoes1 = shoeservice.getShoesById(productId);
		cartservice.addcart(shoes1, quantity,productId);
		
		model.addAttribute("message", "Product Added");
		
		return "welcome";
		}
		else
		{
			model.addAttribute("message", "Invalid Product Entered");
			
			return "welcome";
		}
	
	}
	
	@RequestMapping(value= "/viewcart", method= RequestMethod.POST)
	public ModelAndView showCartPage(@ModelAttribute("user")User user,BindingResult result, Model model)
	{ 	
		List<Cart> cartlist = cartservice.cartList();
		
		
		ModelAndView mav = new ModelAndView("viewCart");
		
		mav.addObject("cart", cartlist);
		
		return mav;
	}
}
