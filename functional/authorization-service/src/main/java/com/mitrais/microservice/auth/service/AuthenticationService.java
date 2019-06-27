package com.mitrais.microservice.auth.service;

import java.util.Optional;

import org.springframework.security.core.Authentication;

/**
 *
 */
public interface AuthenticationService {
	Optional<Authentication> get();

	Optional<String> getUsername();
}
