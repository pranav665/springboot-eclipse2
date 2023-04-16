/*
  package com.example.demo.security;
 



import org.apache.catalina.User;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.cglib.core.internal.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class springSecurityConfiguration {

	//LDPA or database
	//in memory database
	
	
	//InMemoryUserDetailsManager
	//InMemoryUserDetailsManager(UserDetails...users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		Function<String, String> passwordEncoder
		              =  input -> passwordEncoder().encode(input) ;
		
		
		UserDetails user = User.builder().passwordEncoder(passwordEncoder)
												.username("pranav")
												.password("jadhav")
												.roles("USER","ADMIN")
												.build();
												
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
*/

  package com.example.demo.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import javax.security.auth.message.config.AuthConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class springSecurityConfiguration {
	//LDAP or Database
	//In Memory 
	
	//InMemoryUserDetailsManager
	//InMemoryUserDetailsManager(UserDetails... users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails userDetails1 = createNewUser("pranav", "jadhav");
		UserDetails userDetails2 = createNewUser("ranga", "dummy");
		
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder
		= input -> passwordEncoder().encode(input);

		UserDetails userDetails = User.builder()
									.passwordEncoder(passwordEncoder)
									.username(username)
									.password(password)
									.roles("USER","ADMIN")
									.build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//all url r protected
	//login form r shown to unauthorised users
	//CSRF disable
	//frames
	
	@Bean
	public  SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}
	
}