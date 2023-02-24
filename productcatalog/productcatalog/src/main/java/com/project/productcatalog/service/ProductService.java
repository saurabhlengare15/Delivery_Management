package com.project.productcatalog.service;

import java.util.List;

import com.project.productcatalog.model.Product;
import com.project.productcatalog.model.TransactionRequest;

public interface ProductService {
	Product saveProduct(TransactionRequest product);
	List<Product> getAllProducts();
	Product getById(int id);
}
