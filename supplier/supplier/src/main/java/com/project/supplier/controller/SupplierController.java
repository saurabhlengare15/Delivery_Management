package com.project.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.supplier.model.Supplier;
import com.project.supplier.model.TransactionRequest;
import com.project.supplier.model.TransactionResponse;
import com.project.supplier.service.SupplierServiceImpl;

@RestController
@RequestMapping("supplier")
public class SupplierController {
	
	@Autowired
	private SupplierServiceImpl supplierServiceImpl;
	
	@PostMapping(value="inventory", consumes="application/json")
	public TransactionResponse SupplierToInventory(@RequestBody TransactionRequest request){
		return supplierServiceImpl.SupplierToInventory(request);
	}
	
	@PostMapping(consumes="application/json")
	public Supplier saveSupplier(@RequestBody Supplier supplier){
		return supplierServiceImpl.saveSupplier(supplier);
	}
	
	@GetMapping(produces="application/json")
	public List<Supplier> getAllSupplier(){
		return supplierServiceImpl.getAllSupplier();
	}
	
	@GetMapping(value="get/{id}", produces="application/json")
	public Supplier getById(@PathVariable int id){
		return supplierServiceImpl.getById(id);
	}
}
