package com.project.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.search.model.TransactionRequest;
import com.project.search.model.TransactionResponse;
import com.project.search.service.SearchServiceImpl;

@RestController
@RequestMapping("search")
public class SearchController {
	
	@Autowired
	private SearchServiceImpl searchServiceImpl;
	
	@PostMapping(consumes="application/json")
	public TransactionResponse SearchToCart(@RequestBody TransactionRequest request){
		return searchServiceImpl.SearchToCart(request);
	}
}
