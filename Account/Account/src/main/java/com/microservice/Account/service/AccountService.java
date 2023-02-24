package com.microservice.Account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.Account.model.Account;

public interface AccountService {
	Account SaveAccount(Account account);
	List<Account> getAllAccount();
}
