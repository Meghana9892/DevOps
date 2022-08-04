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

import com.spring.model.*;
import com.spring.service.*;


@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ShoeService shoeService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value= "/buy", method= RequestMethod.POST)
	public String cartPage(@ModelAttribute("cart")User userName,BindingResult result, Model model)
	{	
		List<Shoes> cartshoes = cartService.cartshoes();
		
		purchaseService.buynow(cartshoes);
		
		cartService.delete();
		shoeService.setqtyprice();
		
		model.addAttribute("message", "Purchase Complete");	
		 return "shopComplete";
		
	}
	
	@RequestMapping(value= "/report", method= RequestMethod.POST)
	public String purchasereport(@ModelAttribute("admin")Purchase purchase,BindingResult result, Model model)
	{	
		List<Purchase> report = purchaseService.getPurchase();
		
		model.addAttribute("report", report);
		
		return "PurchaseReport";
		
	}
	@RequestMapping(value= "/searchproduct", method= RequestMethod.POST)
	public String shoesreport(@ModelAttribute("admin")Purchase purchase,BindingResult result, Model model)
	{	
		int id = purchase.getPurchaseid();
		List<Shoes> shoes = purchaseService.getpurchaseshoes(id);
		
		model.addAttribute("shoes", shoes);
		
List<Purchase> report = purchaseService.getPurchase();
		
		model.addAttribute("report", report);
		
		return "PurchaseReport";
		
		
		
	}
}
