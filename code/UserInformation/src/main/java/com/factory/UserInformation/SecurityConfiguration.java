package com.factory.UserInformation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration 
{
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		return new MyUserDetailsService();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpsecurity) throws Exception
	{
		httpsecurity.csrf().disable().authorizeHttpRequests()
		.requestMatchers("/home/admin").hasAuthority("Admin")
		.requestMatchers("/home/manager").hasAuthority("Manager")
		.requestMatchers("/home/employee").hasAuthority("Employee")
		.anyRequest().authenticated()
		.and()
		.httpBasic();
		return httpsecurity.build();
	}
}
