package com.project.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.payment.model.Delivery;
import com.project.payment.model.OrderManagement;
import com.project.payment.model.Payment;
import com.project.payment.model.TransactionRequest;
import com.project.payment.model.TransactionResponse;
import com.project.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment savePayment(Payment payment){
		return paymentRepository.save(payment);
	}
	
	public List<Payment> getAllPayment(){
		return paymentRepository.findAll();
	}
	
	public TransactionResponse PaymentToDelivery(TransactionRequest request){
		Payment payment = request.getPayment();
		Delivery delivery = request.getDelivery();
		
		//to get details of order by orderid
		int orid = payment.getOrderId();
		OrderManagement order = restTemplate.getForObject("http://localhost:8089/order/get/"+orid, OrderManagement.class);
		
		delivery.setOrderId(payment.getOrderId());
		delivery.setUserId(order.getUserId());
		delivery.setProductId(order.getProductId());
		delivery.setProductName(order.getProductName());
		delivery.setTotalAmount(order.getTotalAmount());
		delivery.setTransactionId(payment.getTransactionId());
		
		Delivery res = restTemplate.postForObject("http://localhost:8088/delivery", delivery, Delivery.class);
		return new TransactionResponse(res.getDeliveryId());
	}
}
