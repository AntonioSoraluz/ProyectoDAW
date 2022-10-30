package com.reclutamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reclutamiento.model.PerfilPuesto;
import com.reclutamiento.model.Rol;
import com.reclutamiento.model.UnidadOrganica;
import com.reclutamiento.model.Usuario;
import com.reclutamiento.model.repository.EmpleadoRepository;
import com.reclutamiento.model.repository.PerfilPuestoRepository;
import com.reclutamiento.model.repository.RolRepository;
import com.reclutamiento.model.repository.UnidadOrgRepository;
import com.reclutamiento.model.repository.UsuarioRepository;

@Controller
public class LoginController {
	@Autowired
	private UsuarioRepository uRepo;
	@Autowired
	private RolRepository rRepo;
	@Autowired
	private UnidadOrgRepository uoRepo;
	@Autowired
	private PerfilPuestoRepository ppRepo;
	@Autowired
	private EmpleadoRepository eRepo;
	
	@GetMapping("/login")
	public String cargarLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	Usuario u;
	@PostMapping("/home")
	public String validarUsu(@ModelAttribute Usuario usuario, Model model) {		
		u = uRepo.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
		if (u==null) {
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("mensaje","usuario o clave incorrecto");
			return "login";
		}else {
			model.addAttribute("usuario", u);
			model.addAttribute("rol", rRepo.findAll());
			model.addAttribute("unidadorganica", uoRepo.findAll());
			model.addAttribute("lstPerPue", ppRepo.findAll());
			model.addAttribute("lstEmp", eRepo.findAll());
			return "principal";
		}		
	}
}
