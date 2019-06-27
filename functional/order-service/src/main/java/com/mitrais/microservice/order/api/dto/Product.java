package com.mitrais.microservice.order.api.dto;

import java.math.BigDecimal;

import lombok.Data;

/**
 *
 */
@Data
public class Product {
	private Long id;
	private String number;
	private BigDecimal price;
}
