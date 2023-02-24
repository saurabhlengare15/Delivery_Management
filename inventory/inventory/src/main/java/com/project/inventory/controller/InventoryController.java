package com.project.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.inventory.model.Inventory;
import com.project.inventory.service.InventoryServiceImpl;

@RestController
@RequestMapping("inventory")
public class InventoryController {
	
	@Autowired
	private InventoryServiceImpl inventoryServiceImpl;
	
	@PostMapping(consumes="application/json")
	public Inventory saveInventory(@RequestBody Inventory inventory){
		return inventoryServiceImpl.saveInventory(inventory);
	}
	
	@GetMapping(produces="application/json")
	public List<Inventory> getAllInventory(){
		return inventoryServiceImpl.getAllInventory();
	}
	
	@GetMapping(value="get/{id}", produces="application/json")
	public Inventory getById(@PathVariable int id){
		return inventoryServiceImpl.getById(id);
	}
}
