package com.mitrais.microservice.order.repository;

import java.util.List;

import com.mitrais.microservice.order.domain.Order;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>,
		QuerydslPredicateExecutor<Order> {
}
