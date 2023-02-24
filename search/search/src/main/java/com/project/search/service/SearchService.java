package com.project.search.service;

import com.project.search.model.Search;
import com.project.search.model.TransactionRequest;
import com.project.search.model.TransactionResponse;

public interface SearchService {
	TransactionResponse SearchToCart(TransactionRequest search);
}
