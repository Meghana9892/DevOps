package com.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Admin;
import com.spring.model.User;
import com.spring.repository.AdminRepository;

@Service
public class AdminService {

	
	@Autowired
	private AdminRepository arepo;
	
	public void addAdmin(Admin admin)
	{
		
		arepo.save(admin);
	}
	
	
	public boolean changePassword(String adminame,String password)
	{
		boolean output=false;
		List<Admin> admindata = arepo.findAll();
		
		
		for(Admin a:admindata)
		{
			if(a.getaName().toLowerCase().equals(adminame.toLowerCase())) {
			
				a.setaPassword(password);
				arepo.save(a);
				output=true;
				break;
			}
		}
		
		return output;
	}
	
	public boolean validate(String adminname,String password)
	{
		boolean output = false;
		
		List<Admin> adminlist1 = arepo.findAll();
		
		for(Admin a: adminlist1)
		{
			if(a.getaName().toLowerCase().equals(adminname.toLowerCase())&&a.getaPassword().toLowerCase().equals(password.toLowerCase()))
			{
				output=true;
				break;
			}
		}
		
		return output;
	}
	
	
}
