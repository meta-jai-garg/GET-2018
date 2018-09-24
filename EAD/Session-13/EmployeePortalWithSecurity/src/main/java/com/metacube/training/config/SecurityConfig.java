package com.metacube.training.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Class to enable security to existing application
 * 
 * @author Jai Kumar Garg
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// In Memory user creation
		auth.inMemoryAuthentication().withUser("admin@admin.com").password("{noop}admin123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("jaiagarwal52@gmail.com").password("{noop}12345").roles("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("tanu.mittal@metacube.com").password("{noop}123456").roles("EMPLOYEE");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// configuration for different user roles
		http.authorizeRequests().antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')").antMatchers("/employee/*")
				.access("hasRole('ROLE_EMPLOYEE')").and().formLogin().loginPage("/login").failureUrl("/login?error")
				.loginProcessingUrl("/login").successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication auth) throws IOException, ServletException {
						if (auth.getAuthorities().toString().contains("ROLE_EMPLOYEE")) {
							response.sendRedirect("employee/profile");
						} else if (auth.getAuthorities().toString().contains("ROLE_ADMIN")) {
							response.sendRedirect("admin/dashboard");
						}
					}
				}).and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout");
		http.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// method to allow resources without authentication
		web.ignoring().antMatchers("/resources/**").anyRequest();
	}

}