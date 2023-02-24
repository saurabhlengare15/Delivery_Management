package com.microservice.Account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.Account.model.Account;
import com.microservice.Account.service.AccountServiceImpl;

@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@PostMapping(consumes="application/json")
	public Account saveAccount(@RequestBody Account account){
		return accountServiceImpl.SaveAccount(account);
	}
	
	@GetMapping(produces="application/json")
	public List<Account> getAllAccount(){
		return accountServiceImpl.getAllAccount();
	}
}
