package com.reclutamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reclutamiento.model.Usuario;
import com.reclutamiento.service.UsuarioService;

@SessionAttributes({ "ENLACES", "USUARIO" })
@Controller
public class LoginController {

	@Autowired
	private UsuarioService service;

	@RequestMapping("/login")
	public String cargarLogin() {
		return "inicio";
	}

	@RequestMapping(value = "/login", params="logout")
	public String singOut(Model model, RedirectAttributes att) {
		return "inicio";
	}
	@PostMapping("/login")
	public String loguiarse(@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password, RedirectAttributes att, Model model) {
		Usuario user = service.login(username, password);
		model.addAttribute("USUARIO", user);
		att.addAttribute("rol", user.getId_Rol());
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", params = "rol")
	public String home(@RequestParam int rol, Model model) {
		model.addAttribute("ENLACES", service.modulosPorUsuario(rol));
		return "bienvenida";
	}
}
