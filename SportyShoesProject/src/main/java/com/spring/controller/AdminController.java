package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Admin;
import com.spring.model.Shoes;
import com.spring.model.User;
import com.spring.service.AdminService;
import com.spring.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminservice;
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value= "/admin", method= RequestMethod.GET)
	public String showOptionPage(@ModelAttribute("admin") Admin admin,BindingResult result)
	{
		
		return "adminlogin";
		
	}
	@RequestMapping(value= "/adminhome", method= RequestMethod.GET)
	public String showadminPage(@ModelAttribute("admin") Admin admin,BindingResult result)
	{
		
		return "adminhome";
		
	}
	@RequestMapping(value= "/logout", method= RequestMethod.GET)
	public String logoutPage(@ModelAttribute("admin") Admin admin,BindingResult result,Model model)
	{
		model.addAttribute("message", "Logged out Successfully");
		return "adminlogin";
		
	}
	@RequestMapping(value= "/home", method= RequestMethod.GET)
	public String showOptionPage(@ModelAttribute("login") User user,BindingResult result)
	{
		
		return "home";
		
	}
	
	@RequestMapping(value= "/user", method= RequestMethod.POST)
	public String showWelcomePage(@ModelAttribute("user") User user,BindingResult result,Model model)
	{
		List<User> users = userservice.getUsers();
		
		model.addAttribute("users", users);
		return "userData";
	}
	

	@RequestMapping(value= "/adminSignup", method= RequestMethod.GET)
	public String showadminSignupPage(@ModelAttribute("admin") Admin admin,BindingResult result)
	{
		
		return "adminsignup";
		
	}
	
	@RequestMapping(value= "/changepassword", method= RequestMethod.GET)
	public String showchangepasswordPage(@ModelAttribute("admin") Admin admin,BindingResult result)
	{
		
		return "changepassword";
		
	}
	
	@RequestMapping(value= "/adminlogin", method= RequestMethod.POST)
	public String validateAdmin(@ModelAttribute("admin") Admin admin, BindingResult result,Model model)
	{
		String aname = admin.getaName();
		String apassword = admin.getaPassword();
		
		boolean output = adminservice.validate(aname, apassword);
		if(output)
		{

			return "adminhome";
		}
		else
		{
			model.addAttribute("message","Incorrect Username or Password");
			return "adminlogin";
			
		}
	}
		
		@RequestMapping(value= "/password", method= RequestMethod.POST)
		public String validatePassword(@ModelAttribute("admin") Admin admin, BindingResult result,Model model)
		{
			String aname = admin.getaName(); 
			String apassword = admin.getaPassword();		
			
			boolean output = adminservice.changePassword(aname, apassword);
			if(output)
			{
				model.addAttribute("message","Password changed successfully");
				return "changepassword";
			}
			else
			{
				model.addAttribute("message","Admin name doesnot match");
				return "changepassword";
				
			}
	
	}
		
		@RequestMapping(value= "/adminsubmit", method= RequestMethod.POST)
		public String showWelcomePage(@ModelAttribute("admin")Admin admin, BindingResult result, Model model)
		{
			adminservice.addAdmin(admin);
		
				
				return "adminhome";
		
		}
		
		
}
