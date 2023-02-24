package com.project.supplier.service;

import java.util.List;

import com.project.supplier.model.Supplier;
import com.project.supplier.model.TransactionRequest;
import com.project.supplier.model.TransactionResponse;

public interface SupplierService {
	TransactionResponse SupplierToInventory(TransactionRequest supplier);
	List<Supplier> getAllSupplier();
	Supplier saveSupplier(Supplier supplier);
	Supplier getById(int id);
}
