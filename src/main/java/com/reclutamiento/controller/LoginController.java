package com.reclutamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.reclutamiento.model.Operacion;
import com.reclutamiento.model.Usuario;
import com.reclutamiento.security.service.UserService;


@SessionAttributes({"ENLACES",""})
@Controller
public class LoginController {
	
	@Autowired
	private UserService servicio;
	
	@RequestMapping("/login")
	public String cargarLogin() {
		
		return "inicio";
	}
	@RequestMapping("/home")
	public String home(Authentication auth, Model model) {
		//obtener usuario logeado
		String vUsuario = auth.getName();
		//
		Usuario bean = servicio.login(vUsuario);
		//traer enlaces
		List<Operacion> data = servicio.modulosPorUsuario(bean.getRol().getId_Rol());
		//
		model.addAttribute("ENLACES", data); 
		
		return "bienvenida";
	} 
}
