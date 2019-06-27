package com.mitrais.microservice.account;

import java.math.BigDecimal;

import com.mitrais.microservice.account.domain.Account;
import com.mitrais.microservice.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class AccountMain implements CommandLineRunner {
	@Autowired
	private AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(AccountMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account account1 = Account.builder().number("001").username("john").balance(BigDecimal
				.valueOf(100)).build();
		accountRepository.save(account1);
	}
}
