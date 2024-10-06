package com.main.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.main.exception.CategoryNotFoundException;
import com.main.exception.ProductNotFoundException;
import com.main.model.Categories;
import com.main.model.Products;
import com.main.repository.CategoriesRepo;
import com.main.repository.ProductRepo;
import com.main.utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private CategoriesRepo categoryRepo;
	ResponseStructure responseStructure=new ResponseStructure();
	
	@Override
	public ResponseEntity<ResponseStructure> save(Products product) {
		Optional<Categories> optional = categoryRepo.findById(product.getCategories().getCid());
		if(optional.isPresent()) {
		product.setCategories(optional.get());
		productRepo.save(product);
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("product added successfully");
		responseStructure.setData(product);
		return new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);
		}else
			throw new CategoryNotFoundException("Category not found");
	}

	@Override
	public ResponseEntity<ResponseStructure> findByPid(int pid) {
		Optional<Products> optional = productRepo.findById(pid);
		if(optional.isPresent())
		{
		Products product = optional.get();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("product found");
		responseStructure.setData(product);
		return new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);
		}else
			throw new ProductNotFoundException("Product not found");

	}

	@Override
	public ResponseEntity<ResponseStructure> deleteProductByPid(int pid) {
		Optional<Products> optional = productRepo.findById(pid);
		if(optional.isPresent())
		{
		Products product = optional.get();
		productRepo.delete(product);
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Product object deleted successfully");
		responseStructure.setData(product);
		return new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);
		}else
			throw new CategoryNotFoundException("Product not found");

	}

	@Override
	public ResponseEntity<ResponseStructure> getAllProducts(Pageable pageble) {
		 Page<Products> pages = productRepo.findAll(pageble);
		 List<Products> list = pages.get().toList();
		 responseStructure.setStatuscode(HttpStatus.OK.value());
		 responseStructure.setMessage("Categories found");
		 responseStructure.setData(list);
		 return new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure> updateProductById(int pid, Products updatedProduct) {
		Optional<Products> optional = productRepo.findById(pid);
		if(optional.isPresent())
		{
		Products existingProduct = optional.get();
		updatedProduct.setPid(existingProduct.getPid());
		productRepo.save(updatedProduct);
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Product updated deleted successfully");
		responseStructure.setData(updatedProduct);
		return new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);
		}else
			throw new CategoryNotFoundException("Product not found");

	}

}
