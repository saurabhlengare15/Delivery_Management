package com.project.search.model;

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
public class Cart {
	private int cartId;
	private int userId;
	private int productId;
	private String productName;
	private int quantity;
	private double totalAmount;
}
