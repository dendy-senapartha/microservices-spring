package com.mitrais.microservice.auth.event;

import java.util.Optional;

import com.mitrais.microservice.auth.domain.User;
import com.mitrais.microservice.auth.domain.UserProfile;
import com.mitrais.microservice.auth.repository.UserRepository;
import com.mitrais.microservice.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@RepositoryEventHandler
@RequiredArgsConstructor
public class UserProfileEventHandler {
	private final UserRepository userRepository;
	private final AuthenticationService authenticationService;

	@HandleBeforeCreate
	public void handleBeforeCreate(UserProfile profile) {
		authenticationService.getUsername().ifPresent(username->{
			Optional<User> user = userRepository.findById(username);
			user.ifPresent(profile::setUser);
		});
	}
}
