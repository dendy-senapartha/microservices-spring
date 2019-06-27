package com.mitrais.microservice.order.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "tbl_order")
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String productNumber;
	@NonNull
	private Long accountNumber;
	@NonNull
	@Builder.Default
	private int quantity = 1;
	@Builder.Default
	private BigDecimal amount = BigDecimal.ZERO;
	@Builder.Default
	private Status status = Status.PENDING;

	public enum Status{
		REJECTED, PENDING
	}
}
