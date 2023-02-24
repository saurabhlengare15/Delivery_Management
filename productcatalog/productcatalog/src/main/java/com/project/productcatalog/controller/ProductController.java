package com.project.productcatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.productcatalog.model.Product;
import com.project.productcatalog.model.TransactionRequest;
import com.project.productcatalog.service.ProductServiceImpl;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@PostMapping(consumes="application/json")
	public Product saveProduct(@RequestBody TransactionRequest product){
		return productServiceImpl.saveProduct(product);
	}
	
	@GetMapping(produces="application/json")
	public List<Product> getAllProducts(){
		return productServiceImpl.getAllProducts();
	}
	
	@GetMapping(value="get/{id}")
	public Product getById(@PathVariable int id){
		return productServiceImpl.getById(id);
	}

}
