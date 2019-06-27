package com.mitrais.microservice.order.api;

import com.mitrais.microservice.order.api.dto.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@FeignClient("account")
public interface AccountClient {
	@RequestMapping(method = RequestMethod.GET, value = "/accounts/search/findByUsername", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	Resource<Account> findByUsername(@RequestParam("username") String username);
}
