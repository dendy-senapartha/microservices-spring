package com.mitrais.microservice.order.api.dto;

import java.math.BigDecimal;

import lombok.Data;

/**
 *
 */
@Data
public class Account {
	private Long id;
	private BigDecimal balance;
}
