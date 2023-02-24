package com.project.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.cart.model.Cart;
import com.project.cart.model.Ordermanagement;
import com.project.cart.model.TransactionRequest;
import com.project.cart.model.TransactionResponse;
import com.project.cart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Cart saveCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}
	
	public TransactionResponse CartToOrder(TransactionRequest request){
		Cart cart = request.getCart();
		Ordermanagement orderManagement = request.getOrderManagement();
		
		orderManagement.setUserId(cart.getUserId());
		orderManagement.setProductId(cart.getProductId());
		orderManagement.setProductName(cart.getProductName());
		orderManagement.setTotalAmount(cart.getTotalAmount());
		
		Ordermanagement ord = restTemplate.postForObject("http://localhost:8089/order", orderManagement, Ordermanagement.class);
		
		return new TransactionResponse(ord.getOrderId());
	}

}
