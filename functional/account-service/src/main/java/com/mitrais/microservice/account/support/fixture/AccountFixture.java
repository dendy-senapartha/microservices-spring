package com.mitrais.microservice.account.support.fixture;

import java.math.BigDecimal;

import com.mitrais.microservice.account.domain.Account;
import com.mitrais.microservice.account.repository.AccountRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 */
@Configuration
@Profile("fixture")
@RequiredArgsConstructor
public class AccountFixture implements CommandLineRunner {
	private final AccountRepository accountRepository;

	/**
	 * Insert product sample data.
	 * @param args not used
	 */
	@Override
	public void run(String... args) {
		for (AccountFixtureEnum afe : AccountFixtureEnum.values()) {
			Account account = Account.builder()
					.number(afe.getNumber())
					.username(afe.getUsername())
					.balance(afe.getBalance())
					.build();
			accountRepository.save(account);
		}
	}

	/**
	 * Account sample data.
	 */
	@Getter
	@RequiredArgsConstructor
	public enum AccountFixtureEnum {
		STEPHANIE_BRUNNING("stephanie.brunning", "5447814170004851", BigDecimal.valueOf(50)),
		MICHAEL_BENN("michael.benn", "5490800077981990", BigDecimal.valueOf(100));
		private final String username;
		private final String number;
		private final BigDecimal balance;
	}
}
