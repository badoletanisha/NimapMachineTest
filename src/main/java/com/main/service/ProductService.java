package com.main.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.main.model.Products;
import com.main.utility.ResponseStructure;

public interface ProductService {
	ResponseEntity<ResponseStructure> save(Products p);
	ResponseEntity<ResponseStructure> findByPid(int pid);
	ResponseEntity<ResponseStructure> updateProductById(int pid, Products updatedProduct);
	ResponseEntity<ResponseStructure> deleteProductByPid(int pid);
	ResponseEntity<ResponseStructure> getAllProducts(Pageable pageble);
}
