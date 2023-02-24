package com.project.inventory.service;

import java.util.List;

import com.project.inventory.model.Inventory;

public interface InventoryService {
	
	Inventory saveInventory(Inventory inventory);
	List<Inventory> getAllInventory();
	Inventory getById(int id);
}
