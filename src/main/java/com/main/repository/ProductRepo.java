package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer>{
	
}
