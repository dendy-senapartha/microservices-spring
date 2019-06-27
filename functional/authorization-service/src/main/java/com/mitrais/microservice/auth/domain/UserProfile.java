package com.mitrais.microservice.auth.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public class UserProfile {
	@Id
	private String username;

	@NonNull
	@Pattern(regexp = "^[A-Za-z.]+", message = "{validation.firstName.format}")
	@Size(min = 3, max = 60, message = "{validation.firstName.length}")
	private String firstName;

	@NonNull
	@Pattern(regexp = "^[A-Za-z.]+", message = "{validation.firstName.format}")
	@Size(min = 3, max = 60, message = "{validation.firstName.length}")
	private String lastName;

	@NotNull
	@NonNull
	@Email
	@Size(max = 60, message = "{validation.email.length}")
	private String email;

	@OneToOne
	@MapsId
	private User user;
}
