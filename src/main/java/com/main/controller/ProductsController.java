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

import com.main.model.Products;
import com.main.service.ProductService;
import com.main.utility.ResponseStructure;

@RestController
@RequestMapping("api/products")
public class ProductsController {
	@Autowired
	private ProductService service;

	@PostMapping
	public ResponseEntity<ResponseStructure> addProduct(@RequestBody Products product) {
		return service.save(product);
	}

	@GetMapping("/{pid}")
	public ResponseEntity<ResponseStructure> getProductById(@PathVariable int pid){
		return service.findByPid(pid);
	}

	@DeleteMapping("/{pid}")
	public ResponseEntity<ResponseStructure> deleteProductById(@PathVariable int pid) {
		return service.deleteProductByPid(pid);
	}

	@PutMapping("/{pid}")
	public ResponseEntity<ResponseStructure> updateProductById(@PathVariable int pid,@RequestBody Products updatedProduct) {
		return service.updateProductById(pid,updatedProduct);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure> getAllProducts(
			@RequestParam(defaultValue = "1") int page)
			{
				int defaultPageSize=10;
				Pageable pageble=PageRequest.of(page, defaultPageSize);
				return service.getAllProducts(pageble);
				
			}

}
