package com.microservice.Account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.Account.model.Account;
import com.microservice.Account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account SaveAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

}
