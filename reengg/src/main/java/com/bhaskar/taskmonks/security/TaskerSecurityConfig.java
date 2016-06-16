package com.bhaskar.taskmonks.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(2)
public class TaskerSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	   auth.jdbcAuthentication().dataSource(datasource)
	  .usersByUsernameQuery(
	   "select taskeremail,taskerpassword, taskerenabled from tm_tasker where taskeremail=?");
	 } 
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/tasker/**")
                .authenticated()
                .and()
            .formLogin()
	            .loginPage("/become-tasker")
	            .usernameParameter("taskeremail").passwordParameter("taskerpassword")
	            .permitAll()
	            .and()
	        .logout().logoutSuccessUrl("/")
            	.permitAll().and()
                .csrf();
	}
	

}
