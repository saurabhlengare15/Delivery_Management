package com.project.supplier.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
	private Supplier supplier;
	private String productName;
	private int quantity;
}
