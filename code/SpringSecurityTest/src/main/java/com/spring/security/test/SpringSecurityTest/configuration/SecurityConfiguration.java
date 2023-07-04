package com.spring.security.test.SpringSecurityTest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableMethodSecurity
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
		UserDetails normalUser= User.withUsername("Manoj").password(passwordEncoder().encode("Manoj95@#"))
				.roles("normal").build();
		UserDetails adminUser= User.withUsername("Manoj1").password(passwordEncoder().encode("Manoj95@#@"))
				.roles("admin").build();
		InMemoryUserDetailsManager inmemoryuserdetailsmanager=new InMemoryUserDetailsManager(normalUser,adminUser);
		return inmemoryuserdetailsmanager;
		//above programming are used for im memory details configuration
		//return new CustomUserDetailService();
		//this above line use for database configuration
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpsecurity) throws Exception
	{
		httpsecurity.csrf().disable().authorizeHttpRequests()
		.regexMatchers("/home/admin").hasRole("admin")
		.regexMatchers("/home/normal").hasRole("normal")
		.regexMatchers("/home/public").permitAll()
		.anyRequest().authenticated()
		.and().formLogin();
		return httpsecurity.build();
	}
}
