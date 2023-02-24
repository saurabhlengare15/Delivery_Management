package com.project.payment.service;

import java.util.List;

import com.project.payment.model.Payment;
import com.project.payment.model.TransactionRequest;
import com.project.payment.model.TransactionResponse;

public interface PaymentService {
	Payment savePayment(Payment payment);
	List<Payment> getAllPayment();
	TransactionResponse PaymentToDelivery(TransactionRequest request);
}
