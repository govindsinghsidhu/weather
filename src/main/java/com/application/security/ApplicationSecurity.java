package com.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().httpBasic().and().authorizeRequests().antMatchers("/weather/**")
				.access("hasRole('ADMIN') or hasRole('USER')").antMatchers("/actuator/**").access("hasRole('ADMIN')")
				.anyRequest().authenticated();
		return http.build();
	}

	@Autowired
	public void configureAuthenticationManagerBuilder(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("password")).roles("USER").and()
				.withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");
	}

}
