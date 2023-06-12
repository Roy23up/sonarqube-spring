package com.mx.demo.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mx.demo.entity.Rol;
import com.mx.demo.entity.Users;
import com.mx.demo.enums.RolNombre;

import com.mx.demo.services.RolService;
import com.mx.demo.services.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	@GetMapping("registro")
	public String registro() {
		return "registro";
	}
	
	@PostMapping("registrar")
	public ModelAndView registrar(String usuario, String password) {
		ModelAndView mv = new ModelAndView();
		
		if (StringUtils.isBlank(usuario)) {
			mv.setViewName("/registro");
			mv.addObject("error", "La contraseña o nombre no puede estar vacía");
			return mv;
		}
		
		Users users = new Users();
		users.setUsuario(usuario);
		users.setPassword(passwordEncoder.encode(password));
		Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
		Set<Rol> roles = new HashSet<>();
		roles.add(rolUser);
		users.setRoles(roles);
		usuarioService.guardarUsuario(users);
		mv.setViewName("/login");
		mv.addObject("registroOk", "Cuenta creada " + users + " ya puede iniciar sesión");
		
		return mv;		
	}
}
