package com.project.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.inventory.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	Inventory findByproductId(int id);
}
