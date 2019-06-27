package com.mitrais.microservice.order.event;

import java.math.BigDecimal;
import java.security.Principal;
import java.text.NumberFormat;

import com.mitrais.microservice.order.domain.Order;
import com.mitrais.microservice.order.api.AccountClient;
import com.mitrais.microservice.order.api.ProductClient;
import com.mitrais.microservice.order.api.dto.Account;
import com.mitrais.microservice.order.api.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 */
@RepositoryEventHandler
public class CreateOrderEventHandler {
	@Autowired
	private AccountClient accountClient;
	@Autowired
	private ProductClient productClient;

	@HandleBeforeCreate
	public void validate(Order order){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Product product  = productClient.findByNumber(order.getProductNumber()).getContent();
		if(product == null){
			throw new IllegalArgumentException(String.format("Product with number %s not exist.", order.getProductNumber()));
		}

		Account account = accountClient.findByUsername(username).getContent();
		if(account == null){
			throw new IllegalArgumentException(String.format("Could not find account with your name %s. Please setup one first.", username));
		}
		BigDecimal amount = product.getPrice().multiply(new BigDecimal(order.getQuantity()));
		if (amount.compareTo(account.getBalance()) > 0){
			throw new IllegalArgumentException(String.format("Order amount %s is bigger then account balance %s.", NumberFormat
					.getCurrencyInstance().format(amount), NumberFormat.getCurrencyInstance().format(account.getBalance())));
		}else{
			order.setAmount(amount);
		}
	}
}
