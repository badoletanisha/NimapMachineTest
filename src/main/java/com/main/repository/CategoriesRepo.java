package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Categories;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Integer>{
	
}
