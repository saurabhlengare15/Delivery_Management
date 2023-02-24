package com.project.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.order.model.OrderManagement;
import com.project.order.model.TransactionRequest;
import com.project.order.model.TransactionResponse;
import com.project.order.service.OrderServiceImpl;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping(consumes="application/json")
	public OrderManagement saveOrder(@RequestBody OrderManagement order){
		return orderServiceImpl.saveOrder(order);
	}
	
	@GetMapping(produces="application/json")
	public List<OrderManagement> getAllOrder(){
		return orderServiceImpl.getAllOrder();
	}
	
	@PostMapping(value="savePayment", consumes="application/json")
	public TransactionResponse OrderToPayment(@RequestBody TransactionRequest request){
		return orderServiceImpl.OrderToPayment(request);
	}
	
	@GetMapping(value="get/{id}")
	public OrderManagement getById(@PathVariable int id){
		return orderServiceImpl.getById(id);
	}
}
