package com.project.delivery.service;

import java.util.List;

import com.project.delivery.model.Delivery;

public interface DeliveryService {
	Delivery saveDelivery(Delivery delivery);
	List<Delivery> getAllDelivery();
}
