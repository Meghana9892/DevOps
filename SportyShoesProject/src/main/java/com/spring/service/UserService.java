package com.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.model.Shoes;
import com.spring.model.User;
import com.spring.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository urepo;
	
	public void addUser(User user)
	{
		Date date = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate= formatter.format(date);  
		user.setDate(strDate);
		urepo.save(user);
	}
	
	public List<User> getUsers()
	{
		return urepo.findAll();
	}
	
	public boolean validate(String userName,String password)
	{
		boolean output = false;
		
		List<User> users = urepo.findAll();
		
		for(User u: users)
		{
			if(u.getUsername().toLowerCase().equals(userName.toLowerCase())&& u.getPassword().toLowerCase().equals(password.toLowerCase()))
			{
				output = true;
				break;
			}
		}
		
		return output;
	}
	
	public List<User> getUserByName(String username) {
		return urepo.findByusername(username);
	}
	
	public List<User> getUserByFirstname(String firstName) {
		return urepo.findByfirstName(firstName);
	}
	
	public List<User> getUserByAge(int age) {
		return urepo.findByage(age);
	}
	
	public List<User> sortByusername()
	{
		
		List<User> users = urepo.findAll(Sort.by(Sort.Direction.ASC, "username"));
		return users;
	}
	
}
