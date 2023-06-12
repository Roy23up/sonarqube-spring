package com.mx.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.demo.entity.Empleado;
import com.mx.demo.services.EmpleadoServImp;
import com.mx.demo.util.PageRender;

@Controller
@RequestMapping(path = "empleado")
public class EmpleadoController {
	
	//http://localhost:1511/empleado/lista
	
	@Autowired
	private EmpleadoServImp empleadoServImp;
	
	@GetMapping(value = {"/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("lista")
	public String index(Model model) {
		var lista = empleadoServImp.listar();
		model.addAttribute("empleado", lista);
		return "list";
	}
	

	//EN VEZ DEL LIST DE ARRIBA
	/*
	@GetMapping("lista")
	public String index(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 4);
		
		Page<Empleado> empleados = empleadoServImp.findAl(pageRequest);
		
		PageRender<Empleado> pageRender = new PageRender<>("/lista", empleados);
		model.addAttribute("empleados", empleados);
		model.addAttribute("page", pageRender);
		
		return "list";
	}
	*/
	
	//http://localhost:1511/empleado/crear
	@GetMapping("crear")
	public String crear(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "form";
	}
	
	@PostMapping("guardar")
	public String guardar(@Valid Empleado empleado, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		empleadoServImp.guardar(empleado);
		return "redirect:/empleado/lista";
	}
	
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable Long id, Model model) {
		var lista = empleadoServImp.encontrarUno(id);
		model.addAttribute("empleado", lista);
		return "form";
	}
	
	@GetMapping("/{id}/eliminar")
	public String eliminar(@PathVariable Long id) {
		empleadoServImp.eliminar(id);		
		return "redirect:/empleado/lista";
	}
	
}
