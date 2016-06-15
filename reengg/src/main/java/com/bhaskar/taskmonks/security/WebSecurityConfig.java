package com.bhaskar.taskmonks.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	   auth.jdbcAuthentication().dataSource(datasource)
	  .usersByUsernameQuery(
	   "select username,userpassword, userenabled from tm_admin where username=?")
	  .authoritiesByUsernameQuery(
	   "select username, userrole from tm_admin where username=?");
	 } 
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**")
                .authenticated()
                .and()
            .formLogin()
	            .loginPage("/admin/login")
	            .usernameParameter("username").passwordParameter("userpassword")
	            .permitAll()
	            .and()
	        .logout()
            	.permitAll().and()
                .csrf();
	}
	

}
