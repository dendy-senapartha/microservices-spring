package com.mitrais.microservice.product.repository;

import java.util.List;

import com.mitrais.microservice.product.domain.Product;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>,
		QuerydslPredicateExecutor<Product> {
	@RestResource(rel = "by-number")
	Product findByNumber(@Param("number") String number);
	@RestResource(rel = "by-name")
	List<Product> findByNameContainingIgnoreCase(@Param("name")String name);

}
