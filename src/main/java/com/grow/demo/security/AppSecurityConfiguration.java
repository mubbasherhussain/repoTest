package com.grow.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		System.out.println("userDetailsService : "+userDetailsService);
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;				
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/multiplication").hasRole("USERMUL")
			.antMatchers("/subtraction").hasRole("USERSUB")
			.antMatchers("/equal").hasRole("USEREQ")
			.antMatchers("/multiplication").hasAuthority("USERMUL")
			.antMatchers("/subtraction").hasAuthority("USERSUB")
			.antMatchers("/equal").hasAuthority("USEREQ")
			.anyRequest().authenticated()
			.and()
			.csrf().disable()
			.formLogin().disable();			
	}
	
	/*	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN")
	        .and()
	        .withUser("usermul").password(encoder().encode("userPass")).roles("USERMUL")
	        .and()
	        .withUser("usersub").password(encoder().encode("userPass")).roles("USERSUB")
	        .and()
	        .withUser("usereq").password(encoder().encode("userPass")).roles("USEREQ");	    
	}
	 
	@Bean
	public PasswordEncoder  encoder() {
	    return new BCryptPasswordEncoder();
	}
*/
		
}
