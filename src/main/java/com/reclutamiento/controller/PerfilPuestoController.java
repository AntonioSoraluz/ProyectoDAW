package com.reclutamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reclutamiento.model.PerfilPuesto;
import com.reclutamiento.model.Usuario;
import com.reclutamiento.model.repository.PerfilPuestoRepository;
import com.reclutamiento.model.repository.RolRepository;
import com.reclutamiento.model.repository.UnidadOrgRepository;
import com.reclutamiento.model.repository.UsuarioRepository;

@Controller
public class PerfilPuestoController {
	@Autowired
	private RolRepository rRepo;
	@Autowired
	private UnidadOrgRepository uoRepo;
	@Autowired
	private PerfilPuestoRepository pfRepo;
	PerfilPuesto p;
	/*Aun no se usa*/
	/*@GetMapping("/cargarPerfilPuesto")
	public String abrirPerfilPuesto(Model model) {
		model.addAttribute("perfilPuesto", new PerfilPuesto());
		model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		return "perfilesPuesto";
	}*/
	@PostMapping("/grabarPerfilPuesto")
	public String grabarPerfilPuesto(@ModelAttribute PerfilPuesto perfilPuesto, Model model) {
		try {
			pfRepo.save(perfilPuesto);
			model.addAttribute("clase", "alert alert-success");
			model.addAttribute("mensaje", "Perfil de Puesto registrado");
		} catch (Exception e) {
			model.addAttribute("clase", "alert alert-danger");
			model.addAttribute("mensaje", "Error al registrar el Perfil de Puesto");
		}
		
		return "principal";
	}
}
