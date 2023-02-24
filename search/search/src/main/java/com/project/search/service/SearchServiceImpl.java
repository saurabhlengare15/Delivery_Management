package com.project.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.project.search.model.Account;
import com.project.search.model.Cart;
import com.project.search.model.Product;
import com.project.search.model.Search;
import com.project.search.model.TransactionRequest;
import com.project.search.model.TransactionResponse;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public TransactionResponse SearchToCart(TransactionRequest request) {
		Search search = request.getSearch();
		Cart cart = request.getCart();
		Account account = request.getAccount();
		
		//to get details of product by passing product id
		int prid = search.getProductId();
		Product product = restTemplate.getForObject("http://localhost:8084/product/get/"+prid, Product.class);
		
		cart.setProductId(product.getProductId());
		cart.setProductName(product.getProductName());
		cart.setQuantity(search.getQuantity());
		cart.setUserId(account.getUserId());
		
		double totalamt = search.getQuantity()*product.getPrice();
		cart.setTotalAmount(totalamt);
		
		Cart cartResponse = restTemplate.postForObject("http://localhost:8087/cart", cart, Cart.class);
		return new TransactionResponse(search,cartResponse.getCartId());
	}

}
