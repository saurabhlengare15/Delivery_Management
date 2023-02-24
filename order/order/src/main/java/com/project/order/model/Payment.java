package com.project.order.model;

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
public class Payment {
	
	private int transactionId;
	private int orderId;
	private int userId;
	private double totalAmount;
}
