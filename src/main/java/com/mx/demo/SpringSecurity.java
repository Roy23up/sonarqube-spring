/*
 * package com.mx.demo;
 

import org.springframework.context.annotation.Bean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//import com.mx.userDetailsService.detailUserService;

@Configuration
//@EnableWebSecurity
public class SpringSecurity {

	//@Autowired
	//private detailUserService detailUserService;
	
	/*
	//PRIMERA FORMA
		
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	*/
	
	/*
	 * SEGUNDA FORMA
	 * 
	@Bean
	public BCryptPasswordEncoder bpasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	*/
	/*
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		{
			//USAR ESTADO DE MEMORIA Y NO EN BASE DE DATOS
			auth
			.inMemoryAuthentication()
			.withUser("user")
			.password("1234")
			.and()
			.withUser("Admin")
			.password("123456789")
			.roles("user", "Admin");
			
			auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
		}
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		
		http
		.authorizeHttpRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	*/
	/*
	//TERCERA FORMA
	@Bean
	public UserDetailsService userDetailsService(){
		var user = User.withUsername("roy")
			.password("12345")
			.roles("read")
			.build();
		
		return new InMemoryUserDetailsManager(user);		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance(); //NO APTO PARA PRODUCCION
	}
}
*/