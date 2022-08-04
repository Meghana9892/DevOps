package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByusername(String username);

	public List<User> findByfirstName(String firstName);

	public List<User> findByage(int age);

}
