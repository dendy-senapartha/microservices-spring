package com.mitrais.microservice.account.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 */
@Entity
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@RequiredArgsConstructor
public class Account implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String number;
	@NonNull
	private String username;
	@Builder.Default
	private BigDecimal balance = BigDecimal.ZERO;

	public void withdraw(BigDecimal amount) {
		balance = balance.subtract(amount);
	}

	public void deposit(BigDecimal amount) {
		balance = balance.add(amount);
	}
}
