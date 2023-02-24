package com.project.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.productcatalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findByProductId(int id);
}
