package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.exception.CategoryNotFoundException;
import com.main.model.Categories;
import com.main.model.Products;
import com.main.repository.CategoriesRepo;
import com.main.utility.ResponseStructure;

@Service
public class CategoriesServiceImpl implements CategoriesService{

	@Autowired
	private CategoriesRepo categoryRepo;
	ResponseStructure responseStructure=new ResponseStructure<>();

	@Override
	public ResponseEntity<ResponseStructure> save(Categories c) {
		Categories category = categoryRepo.save(c);
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setMessage("Catagories inserted successfully");
		responseStructure.setData(category);
		return new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<ResponseStructure> findByCid(int cid) {
		Optional<Categories> byId = categoryRepo.findById(cid);
		if(byId.isPresent())
		{
			Categories categories = byId.get();
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Category found");
			responseStructure.setData(categories);
			return new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);
		}else
			throw new CategoryNotFoundException("Cateogory not found");

	}

	@Override
	public ResponseEntity<ResponseStructure> deleteByCid(int cid) {
		Optional<Categories> byId = categoryRepo.findById(cid);
		if(byId.isPresent())
		{
			Categories categories = byId.get();
			categoryRepo.delete(categories);
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Category deleted successfully");
			responseStructure.setData(categories);
			return new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);
		}else
			throw new CategoryNotFoundException("Cateogory not found");

	}


	@Override
	public ResponseEntity<ResponseStructure> updateCategory(Categories updatedCategory, int cid) {
		// TODO Auto-generated method stub
		Optional<Categories> byId = categoryRepo.findById(cid);
		if(byId.isPresent())
		{
			Categories existCategories = byId.get();
			updatedCategory.setCid(existCategories.getCid());
			categoryRepo.save(updatedCategory);
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Category updated successfully");
			responseStructure.setData(updatedCategory);
			return new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);
		}else
			throw new CategoryNotFoundException("Cateogory not found");
	}

	@Override
	public ResponseEntity<ResponseStructure> getAllCategories(Pageable pageble) {
		Page<Categories> pages = categoryRepo.findAll(pageble);
		List<Categories> list = pages.get().toList();
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setMessage("Categories found");
		responseStructure.setData(list);
		return new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);
	}

}
