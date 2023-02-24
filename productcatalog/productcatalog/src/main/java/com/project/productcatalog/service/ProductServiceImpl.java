package com.project.productcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.productcatalog.model.Inventory;
import com.project.productcatalog.model.Product;
import com.project.productcatalog.model.TransactionRequest;
import com.project.productcatalog.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(TransactionRequest request) {
		Product product = request.getProduct();
//		Inventory inventory = request.getInventory();
		
		int prid = request.getProductId();
		Inventory res = restTemplate.getForObject("http://localhost:8083/inventory/get/"+prid, Inventory.class);
		
		product.setProductId(request.getProductId());
		product.setProductName(res.getProductName());
		product.setQuantity(res.getQuantity());
		product.setPrice(request.getPrice());
		
		return productRepository.save(product);
	}
	
	public Product getById(int id){
		return productRepository.findByProductId(id);
	}

}
