package com.mx.demo.security.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mx.demo.entity.Users;

import lombok.Data;

@Service
@Data
public class UsuarioPrincipal implements UserDetails{

	private int id;
	private String usuario;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	public UsuarioPrincipal(int id, String usuario, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.authorities = authorities;
	}

	public static UsuarioPrincipal build(Users users) {
		List<GrantedAuthority> authorities = users.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
		
		return new UsuarioPrincipal(users.getId(), users.getUsuario(), users.getPassword(), authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	
}
