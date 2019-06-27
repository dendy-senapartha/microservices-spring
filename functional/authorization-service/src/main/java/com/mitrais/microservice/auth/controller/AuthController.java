package com.mitrais.microservice.auth.controller;

import java.security.Principal;
import java.util.Optional;

import com.mitrais.microservice.auth.domain.User;
import com.mitrais.microservice.auth.domain.UserProfile;
import com.mitrais.microservice.auth.repository.UserProfileRepository;
import com.mitrais.microservice.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
	private final UserProfileRepository userProfileRepository;

	@GetMapping("/info")
	public ResponseEntity<?> info(Principal principal) {
		if (principal != null) {
			Optional<UserProfile> user = userProfileRepository.findById(principal.getName());
			if (user.isPresent()) {
				Resource<UserProfile> resource = new Resource<>(user.get());
				resource.add(ControllerLinkBuilder.linkTo(AuthController.class)
						.slash("info").withSelfRel());
				return ResponseEntity.ok(resource);
			}
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}
}
