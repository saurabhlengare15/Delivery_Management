package com.project.order.service;

import java.util.List;
import com.project.order.model.OrderManagement;
import com.project.order.model.TransactionRequest;
import com.project.order.model.TransactionResponse;

public interface OrderService {
	OrderManagement saveOrder(OrderManagement order);
	List<OrderManagement> getAllOrder();
	TransactionResponse OrderToPayment(TransactionRequest request);
	OrderManagement getById(int id);
}
