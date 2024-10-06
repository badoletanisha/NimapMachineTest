package com.main.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.main.model.Categories;
import com.main.utility.ResponseStructure;

public interface CategoriesService {
	ResponseEntity<ResponseStructure> save(Categories c);
	ResponseEntity<ResponseStructure> findByCid(int cid);
	ResponseEntity<ResponseStructure> deleteByCid(int cid);
	ResponseEntity<ResponseStructure> updateCategory(Categories c, int cid);
	ResponseEntity<ResponseStructure> getAllCategories(Pageable pageble);
}
