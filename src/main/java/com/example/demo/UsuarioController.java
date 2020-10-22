package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.Usuario;
import com.example.demo.Repository.UsuarioRepositorio;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepositorio repositorio;

	@GetMapping("/home")
	public String home(Model modelo, Usuario usuario) {		
		modelo.addAttribute("usuario", new Usuario() );	
		modelo.addAttribute("usuarios", repositorio.findAll());
		return "home";
	}
	
	@GetMapping("/form")
	public String form(Model modelo, Usuario usuario) {
		modelo.addAttribute("usuario", new Usuario() );	
		//modelo.addAttribute("usuarios", repositorio.findAll());		
		return "form";
	}
	
	@PostMapping("/form")
	public String crearUsuario(Model modelo, Usuario usuario) {
		modelo.addAttribute("usuario", new Usuario() );	
		repositorio.save(usuario);
		modelo.addAttribute("usuarios", repositorio.findAll());		
		return "home";
	}
}
