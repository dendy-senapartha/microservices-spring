package com.mitrais.microservice.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 *
 */
@Configuration
@EnableResourceServer
@RequiredArgsConstructor
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
	private final TokenStore tokenStore;

	@Override
	public void configure(ResourceServerSecurityConfigurer configurer) {
		configurer.tokenStore(tokenStore);
	}

	@Override
	public void configure(final HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST,"/users").permitAll()
				.antMatchers(HttpMethod.GET,"/users").permitAll()
				.anyRequest().authenticated();
	}
}
