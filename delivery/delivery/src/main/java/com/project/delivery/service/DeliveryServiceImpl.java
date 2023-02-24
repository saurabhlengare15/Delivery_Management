package com.project.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.delivery.model.Delivery;
import com.project.delivery.repository.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired
	private DeliveryRepository deliveryRepository;

	@Override
	public Delivery saveDelivery(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}

	@Override
	public List<Delivery> getAllDelivery() {
		return deliveryRepository.findAll();
	}

}
