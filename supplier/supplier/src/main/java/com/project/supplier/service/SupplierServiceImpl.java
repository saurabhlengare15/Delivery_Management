package com.project.supplier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.supplier.model.Inventory;
import com.project.supplier.model.Supplier;
import com.project.supplier.model.TransactionRequest;
import com.project.supplier.model.TransactionResponse;
import com.project.supplier.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public TransactionResponse SupplierToInventory(TransactionRequest request) {
		Supplier supplier = request.getSupplier();
		Inventory inventory = request.getInventory();
		
		inventory.setProductId(supplier.getProductId());
		inventory.setProductName(supplier.getProductName());
		
		//to get data of existing inventory 
		int prid = supplier.getProductId();
		Inventory res = restTemplate.getForObject("http://localhost:8083/inventory/get/"+prid, Inventory.class);
		
		//to set inventory quantity
		int totalQuantity = res.getQuantity()+supplier.getQuantity();
		inventory.setQuantity(totalQuantity);
		
		//to post data to inventory
		Inventory response = restTemplate.postForObject("http://localhost:8083/inventory", inventory, Inventory.class);
		
		//to get data of existing supplier
		int supid = supplier.getProductId();
		Supplier supres = restTemplate.getForObject("http://localhost:8086/supplier/get/"+supid, Supplier.class);
		
		//to update existing suppliers quantity
		supplier.setQuantity(supres.getQuantity()-supplier.getQuantity());
		supplierRepository.save(supplier);
		return new TransactionResponse(supplier,response.getProductName(), response.getQuantity());
	}

	@Override
	public List<Supplier> getAllSupplier() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier getById(int id) {
		return supplierRepository.findByProductId(id);
	}

}
