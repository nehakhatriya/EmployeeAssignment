package com.employee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("GUEST"))
			.withUser(users.username("mary").password("test123").roles("GUEST","ADMIN"))
			.withUser(users.username("susan").password("test123").roles("GUEST","USER"));
		
	}
@Override
protected void configure(HttpSecurity http) throws Exception {
	
	http.authorizeRequests()
	.antMatchers("/app/employee","/").permitAll()
	.antMatchers("/app/employee/list").hasAnyRole("ADMIN","USER")
	.antMatchers("/app/employee/delete","app/employee/update").hasAnyRole("ADMIN")
	.antMatchers("/app/employee/addEmployee").hasRole("USER")
	.and()
	.formLogin()
	.loginPage("/app/employee/showLoginPage")
	.loginProcessingUrl("/authenticateTheUser")
	.permitAll()
	.and()
	.logout()
	.logoutSuccessUrl("/")
	.permitAll()
	.and()
	.exceptionHandling()
	.accessDeniedPage("/app/employee/access-denied");;
}
}
