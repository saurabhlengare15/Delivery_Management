package com.project.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment.model.Payment;
import com.project.payment.model.TransactionRequest;
import com.project.payment.model.TransactionResponse;
import com.project.payment.service.PaymentServiceImpl;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	private PaymentServiceImpl paymentServiceImpl;
	
	@PostMapping(consumes="application/json")
	public Payment savePayment(@RequestBody Payment payment){
		return paymentServiceImpl.savePayment(payment);
	}
	
	@GetMapping(produces="application/json")
	public List<Payment> getAllPayment(){
		return paymentServiceImpl.getAllPayment();
	}
	
	@PostMapping(value="saveDelivery", consumes="application/json")
	public TransactionResponse PaymentToDelivery(@RequestBody TransactionRequest request){
		return paymentServiceImpl.PaymentToDelivery(request);
	}
}
