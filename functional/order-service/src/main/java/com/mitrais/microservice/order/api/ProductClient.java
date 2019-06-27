package com.mitrais.microservice.order.api;

import com.mitrais.microservice.order.api.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@FeignClient("product")
public interface ProductClient {
	@RequestMapping(method = RequestMethod.GET, value = "/products/search/findByNumber", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	Resource<Product>findByNumber(@RequestParam("number")String number);
}
