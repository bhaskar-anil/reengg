package com.bhaskar.taskmonks.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class AdminSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@EnableWebSecurity
	public static class SampleMultiHttpSecurityConfig {
		@Autowired
		DataSource datasource;
		
		@Autowired
		 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		   auth.jdbcAuthentication().dataSource(datasource)
		  .usersByUsernameQuery(
		   "SELECT useremail, password, enabled FROM tm_user WHERE useremail=?")
		  .authoritiesByUsernameQuery(
		   "SELECT useremail, role FROM tm_admin WHERE useremail=?");
		 } 
	
	@Configuration
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http				
				.authorizeRequests()
						.antMatchers("/admin/**").hasRole("ADMIN")
						.antMatchers("/user/**").hasRole("USER")
						.antMatchers("/tasker/**").hasRole("TASKER")					
		                .and()
	                .formLogin()
	    	            .loginPage("/login")
	    	            .usernameParameter("username").passwordParameter("userpassword")
	    	            .permitAll()
	    	            .and()
	    	        .logout()
	                	.permitAll()
	                	.and()
	                    .csrf();
	    	}
	}

}}