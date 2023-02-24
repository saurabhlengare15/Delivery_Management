package com.project.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.delivery.model.Delivery;
import com.project.delivery.service.DeliveryServiceImpl;

@RestController
@RequestMapping("delivery")
public class DeliveryController {

	@Autowired
	private DeliveryServiceImpl deliveryServiceImpl;
	
	@PostMapping(consumes="application/json")
	public Delivery saveDelivery(@RequestBody Delivery delivery){
		return deliveryServiceImpl.saveDelivery(delivery);
	}
	
	@GetMapping(produces="application/json")
	public List<Delivery> getAllDelivery(){
		return deliveryServiceImpl.getAllDelivery();
	}
}
