package com.project.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.payment.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
