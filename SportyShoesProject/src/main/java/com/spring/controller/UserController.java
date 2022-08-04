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
import com.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	@Autowired
	private ShoeService shoeservice;
	
	@RequestMapping(value= "/signup", method= RequestMethod.GET)
	public String showSignPage(@ModelAttribute("signup") User user,BindingResult result)
	{
		
		return "signup";
		
	}
	
	@RequestMapping(value= "/login", method= RequestMethod.GET)
	public String showLoginPage(@ModelAttribute("login") User user,BindingResult result)
	{
		
		return "login";
		
	}
	
	@RequestMapping(value= "/logoutuser", method= RequestMethod.GET)
	public String LogoutPage(@ModelAttribute("login") User user,BindingResult result,Model model)
	{
		model.addAttribute("message", "Logged out successfully");
		return "login";
		
	}
	
	
	@RequestMapping(value= "/submit", method= RequestMethod.POST)
	public String showWelcomePage(@ModelAttribute("signup") User user,@ModelAttribute("cart")Shoes shoes,BindingResult result, Model model)
	{
		userservice.addUser(user);
		String username= user.getUsername();
		String password = user.getPassword();  	
		List<Shoes> shoelist = shoeservice.getshoes();
		
		
			model.addAttribute("Name",username);
			model.addAttribute("shoes",shoelist);
			
			return "welcome";
	
	}
	
	@RequestMapping(value= "/search", method= RequestMethod.POST)
	public String searchbynamePage(@ModelAttribute("user") User user,BindingResult result, Model model)
	{
		String firstname = user.getFirstName();
		 	
		List<User> users = userservice.getUserByFirstname(firstname);
		
			model.addAttribute("users",users);
			
			return "userData";
	
	}
	
	@RequestMapping(value= "/searchbyage", method= RequestMethod.POST)
	public String searchbyage(@ModelAttribute("user") User user,BindingResult result, Model model)
	{
		int age = user.getAge();
		 	
		List<User> users = userservice.getUserByAge(age);
		
			model.addAttribute("users",users);
			
			return "userData";
	
	}
	
	@RequestMapping(value= "/sortuserName", method= RequestMethod.POST)
	public String sortProductsPage(@ModelAttribute("user")User user,BindingResult result,Model model)
	{
		List<User> users = userservice.sortByusername();
		
		model.addAttribute("users",users);
		
		return "userData";
		
	}
	

	@RequestMapping(value= "/welcome", method= RequestMethod.POST)
	public String showHomePage(@ModelAttribute("cart")Shoes shoes,BindingResult result, Model model)
	{
		List<Shoes> shoelist = shoeservice.getshoes();
		
		model.addAttribute("shoes",shoelist);
		return "welcome";
	
	}
	
	
	@RequestMapping(value= "/loginuser", method= RequestMethod.POST)
	public String validateLogin(@ModelAttribute("login") User user,@ModelAttribute("cart")Shoes shoes, BindingResult result,Model model)
	{
		String username= user.getUsername();
		String password = user.getPassword();  	
		List<Shoes> shoelist = shoeservice.getshoes();
		
		boolean output = userservice.validate(username, password);
		if(output)
		{
			model.addAttribute("Name",username);
			model.addAttribute("shoes",shoelist);
			
			return "welcome";
		}
		else
		{
			model.addAttribute("message","Incorrect Username or Password");
			return "login";
		}
	}
	
	
}


