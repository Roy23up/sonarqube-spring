/*package com.mx.demo.userDetailsService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mx.demo.entity.Users;
import com.mx.demo.repository.UsersRepository;



@Service
public class detailUserService implements UserDetailsService{

	@Autowired
	UsersRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users us = repository.findByUsuario(username);
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDetails = new User(us.getUsuario(), us.getPassword(), roles);
		
		return userDetails;
	}
	
	
}
*/