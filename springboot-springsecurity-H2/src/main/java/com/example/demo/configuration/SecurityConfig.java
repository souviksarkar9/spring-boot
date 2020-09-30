package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {

		// User Configuration in memory- no Database
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN").and().withUser("user")
//				.password("{noop}user").roles("USER").and().withUser("guest").password("{noop}guest").roles("GUEST");

		// User Configuration with DB
		auth.userDetailsService(userService);

	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/test")
				.permitAll().antMatchers("/guest/*").permitAll()
				.antMatchers("*/h2-console/*").permitAll()
				.antMatchers("*/setData").hasRole("ADMIN")
				.antMatchers("*/getData").hasRole("USER").anyRequest().authenticated()
				.and().formLogin().and().logout();

		http.headers().frameOptions().sameOrigin();
	}

}
