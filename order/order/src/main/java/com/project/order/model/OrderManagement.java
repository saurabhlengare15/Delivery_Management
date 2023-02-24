package com.project.order.model;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderManagement {
	
	@Id
	@GeneratedValue
	private int orderId;
	private int userId;
	private int productId;
	private String productName;
	private double totalAmount; 
}
