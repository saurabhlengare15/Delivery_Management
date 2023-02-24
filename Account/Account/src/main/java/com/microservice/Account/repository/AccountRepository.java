package com.microservice.Account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.Account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
