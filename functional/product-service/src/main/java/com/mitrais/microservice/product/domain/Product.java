package com.mitrais.microservice.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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

@Entity
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@RequiredArgsConstructor
public class Product implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String number;
	@NonNull
	private String name;
	private String description;
	@Builder.Default
	@NonNull
	private BigDecimal price = BigDecimal.ZERO;
}
