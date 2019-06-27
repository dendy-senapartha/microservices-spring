package com.mitrais.microservice.auth.event;

import java.util.Optional;

import com.mitrais.microservice.auth.domain.User;
import com.mitrais.microservice.auth.domain.UserProfile;
import com.mitrais.microservice.auth.repository.UserRepository;
import com.mitrais.microservice.auth.service.AuthenticationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

/**
 *
 */
@ExtendWith(MockitoExtension.class)
class UserProfileEventHandlerTest {
	@Mock
	private UserRepository userRepository;
	@Mock
	private AuthenticationService authenticationService;

	@BeforeEach
	void init(){
		Mockito.when(userRepository.findById(any(String.class))).thenReturn(Optional.of(
				User.builder().username("test").build()));
		Mockito.when(authenticationService.getUsername()).thenReturn(Optional.of("test"));
	}

	@Test
	void handleBeforeCreate() {
		UserProfileEventHandler upeh = new UserProfileEventHandler(userRepository, authenticationService);

		UserProfile userProfile = UserProfile.builder()
				.email("test@example.com")
				.firstName("test")
				.lastName("test")
				.build();
		upeh.handleBeforeCreate(userProfile);
		assertThat(userProfile.getUser().getUsername()).isEqualTo("test");
	}
}