package com.project.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.order.model.OrderManagement;

@Repository
public interface OrderRepository extends JpaRepository<OrderManagement, Integer> {
	OrderManagement findByOrderId(int id);
}
