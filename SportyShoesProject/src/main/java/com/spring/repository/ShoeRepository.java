package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Shoes;

public interface ShoeRepository extends JpaRepository<Shoes, Integer> {

	
}
