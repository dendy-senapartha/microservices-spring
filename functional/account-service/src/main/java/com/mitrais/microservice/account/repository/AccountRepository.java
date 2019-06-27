package com.mitrais.microservice.account.repository;

import com.mitrais.microservice.account.domain.Account;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long>,
		QuerydslPredicateExecutor<Account> {
	@RestResource(rel = "by-number")
	Account findByNumber(@Param("number") String number);
	@RestResource(rel = "by-username")
	Account findByUsername(@Param("username") String username);

}
