package com.project.cart.service;

import java.util.List;

import com.project.cart.model.Cart;
import com.project.cart.model.TransactionRequest;
import com.project.cart.model.TransactionResponse;

public interface CartService {
	Cart saveCart(Cart cart);
	List<Cart> getAllCart();
	TransactionResponse CartToOrder(TransactionRequest request);
}
