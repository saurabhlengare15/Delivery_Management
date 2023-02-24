package com.project.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ordermanagement {
	private int orderId;
	private int userId;
	private int productId;
	private String productName;
	private double totalAmount; 
}
