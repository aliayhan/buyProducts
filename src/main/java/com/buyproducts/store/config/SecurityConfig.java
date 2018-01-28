package com.buyproducts.store.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).
				usersByUsernameQuery("SELECT user_name, password, enabled FROM users WHERE user_name=?").
				authoritiesByUsernameQuery("SELECT user_name, role FROM roles WHERE user_name=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
			.antMatchers("/content","/contentAndProducts").hasRole("USER")
			.anyRequest().authenticated().and()
			.formLogin().loginPage("/login").permitAll().and()
			.logout().permitAll().and()
			.formLogin().defaultSuccessUrl("/content").and()
			.exceptionHandling().accessDeniedPage("/403").and()
			.csrf().disable();
	}

}