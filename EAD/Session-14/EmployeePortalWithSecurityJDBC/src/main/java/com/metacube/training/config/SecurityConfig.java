package com.metacube.training.config;

import java.io.IOException;

import javax.sql.DataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	 * @Autowired private DataSource dataSource;
	 */

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication().withUser("admin@admin.com").password(
		 * "{noop}admin123").roles("ADMIN");
		 * auth.inMemoryAuthentication().withUser("jaiagarwal52@gmail.com").password(
		 * "{noop}12345").roles("EMPLOYEE");
		 * auth.inMemoryAuthentication().withUser("tanu.mittal@metacube.com").password(
		 * "{noop}123456").roles("EMPLOYEE");
		 */

		/*
		 * auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).
		 * dataSource(dataSource)
		 * .usersByUsernameQuery("select emailId, password, isActive from employee where emailId=?"
		 * )
		 * .authoritiesByUsernameQuery("select username, role from userroles where username=?"
		 * );
		 */
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/*").access("hasRole('ADMIN')").antMatchers("/employee/*")
				.access("hasRole('EMPLOYEE')").and().formLogin().loginPage("/login").usernameParameter("username")
				.passwordParameter("password").failureUrl("/login?error").loginProcessingUrl("/login")
				.successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication auth) throws IOException, ServletException {
						if (auth.getAuthorities().toString().contains("EMPLOYEE")) {
							response.sendRedirect("employee/profile");
						} else if (auth.getAuthorities().toString().contains("ADMIN")) {
							response.sendRedirect("admin/dashboard");
						}
					}
				}).and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout");
		http.csrf().disable();
	}

}