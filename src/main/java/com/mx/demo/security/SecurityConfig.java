package com.mx.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mx.demo.configurations.CustomAccessDeniedHandler;
import com.mx.demo.security.services.UserDetailsServiceImp;


@SpringBootConfiguration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired(required = true)
	UserDetailsServiceImp userDetailsServiceImp;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder.userDetailsService(userDetailsServiceImp).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeRequests()
			.antMatchers("/","/index","/error","/frbidn","/login","/usuario/registro")
			.permitAll()
			.antMatchers("/usuario/registro")
			.permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginProcessingUrl("/signin")
			.loginPage("/login").permitAll()
			.defaultSuccessUrl("/index")
			.usernameParameter("usuario")
			.passwordParameter("password")
			.and()
			.exceptionHandling().accessDeniedHandler(accessDeniedHandler())
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout").permitAll()
			.deleteCookies("JSESSIONID")
			.and()
			.rememberMe().tokenValiditySeconds(360000).key("secret").rememberMeParameter("checkRememberMe");
	}
	
}
