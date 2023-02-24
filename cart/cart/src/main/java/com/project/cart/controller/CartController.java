package com.project.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cart.model.Cart;
import com.project.cart.model.TransactionRequest;
import com.project.cart.model.TransactionResponse;
import com.project.cart.service.CartServiceImpl;

@RestController
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@PostMapping(consumes="application/json")
	public Cart savecart(@RequestBody Cart cart){
		return cartServiceImpl.saveCart(cart);
	}
	
	@GetMapping(produces="application/json")
	public List<Cart> getAllCart(){
		return cartServiceImpl.getAllCart();
	}
	
	@PostMapping(value="savecart", consumes="application/json")
	public TransactionResponse CartToOrder(@RequestBody TransactionRequest request){
		return cartServiceImpl.CartToOrder(request);
	}

}
