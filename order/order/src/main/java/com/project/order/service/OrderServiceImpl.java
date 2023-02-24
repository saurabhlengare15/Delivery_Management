package com.project.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.order.model.OrderManagement;
import com.project.order.model.Payment;
import com.project.order.model.TransactionRequest;
import com.project.order.model.TransactionResponse;
import com.project.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public OrderManagement saveOrder(OrderManagement order) {
		return orderRepository.save(order);
	}

	@Override
	public List<OrderManagement> getAllOrder() {
		return orderRepository.findAll();
	}
	
	public TransactionResponse OrderToPayment(TransactionRequest request){
		OrderManagement order = request.getOrder();
		Payment payment = request.getPayment();
		
		payment.setOrderId(order.getOrderId());
		payment.setUserId(order.getUserId());
		payment.setTotalAmount(order.getTotalAmount());
		
		Payment res = restTemplate.postForObject("http://localhost:8085/payment", payment, Payment.class);
		return new TransactionResponse(res.getTransactionId());
	}
	
	public OrderManagement getById(int id){
		return orderRepository.findByOrderId(id);
	}

}
