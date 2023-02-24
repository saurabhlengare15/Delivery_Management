package com.project.delivery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Delivery {
	
	@Id
	@GeneratedValue
	private int deliveryId;
	private int orderId;
	private int userId;
	private int productId;
	private String productName;
	private double totalAmount; 
	private int transactionId;
}
