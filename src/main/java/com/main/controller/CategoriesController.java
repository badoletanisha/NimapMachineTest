package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Categories;
import com.main.service.CategoriesService;
import com.main.utility.ResponseStructure;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {
	@Autowired
	private CategoriesService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure> postCategories(@RequestBody Categories c) {
		return service.save(c);
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<ResponseStructure> getCategories(@PathVariable int cid) {
		return service.findByCid(cid);
	}
	
	@DeleteMapping("/{cid}")
	public ResponseEntity<ResponseStructure> deleteCategories(@PathVariable int cid) {
		return service.deleteByCid(cid);
	}
	
	@PutMapping("/{cid}")
	public ResponseEntity<ResponseStructure> updateCategories(@PathVariable int cid, @RequestBody Categories c) {
		return service.updateCategory(c,cid);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure> getAllCategories(
	         @RequestParam(defaultValue = "1") int page) {
		int dSize=10;
		Pageable pageble=PageRequest.of(page, dSize);
		return service.getAllCategories(pageble);
	}
}
