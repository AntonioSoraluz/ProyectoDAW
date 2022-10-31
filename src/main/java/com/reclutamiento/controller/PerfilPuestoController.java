package com.reclutamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reclutamiento.model.PerfilPuesto;
import com.reclutamiento.model.repository.PerfilPuestoRepository;
import com.reclutamiento.model.repository.RolRepository;
import com.reclutamiento.model.repository.UnidadOrgRepository;

@Controller
public class PerfilPuestoController {
	@Autowired
	private RolRepository rRepo;
	@Autowired
	private UnidadOrgRepository uoRepo;
	@Autowired
	private PerfilPuestoRepository ppRepo;
	PerfilPuesto p;
	
	@GetMapping("/listarPerPue")
	public String listarPerfilPuesto(Model model) {
		model.addAttribute("pagina", "perfilesPuesto");
		model.addAttribute("modulo", "perfilpuesto");
		model.addAttribute("lstPerPue", ppRepo.findAll());
		return "principal";
	}
	
	@GetMapping("/cargarPerPue")
	public String abrirPerfilPuesto(Model model) {
		model.addAttribute("perfilPuesto", new PerfilPuesto());
		model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		model.addAttribute("pagina", "mantPerPue");
		model.addAttribute("modulo", "regPerPue");
		return "principal";
	}
	@PostMapping("/grabarPerPue")
	public String grabarPerfilPuesto(@ModelAttribute PerfilPuesto perfilPuesto, Model model) {
		try {
			ppRepo.save(perfilPuesto);
			model.addAttribute("clase", "alert alert-success");
			model.addAttribute("mensaje", "Perfil de Puesto registrado");
		} catch (Exception e) {
			model.addAttribute("clase", "alert alert-danger");
			model.addAttribute("mensaje", "Error al registrar el Perfil de Puesto");
			model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		}
		return "mantPerPue";
	}
	@PostMapping("/buscarPerfil")
	public String BuscarPerfilP(@ModelAttribute PerfilPuesto p, Model model) {
		model.addAttribute("perfilPuesto", ppRepo.findById(p.getClave_perfil()));
		model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		model.addAttribute("pagina", "mantPerPue");
		model.addAttribute("modulo", "regPerPue");
		return "principal";
	}
	@PostMapping("/eliminarPerfil")
	public String EliminarPerfilP(@ModelAttribute PerfilPuesto p, Model model) {
		ppRepo.deleteById(p.getClave_perfil());
		model.addAttribute("lstPerPue", ppRepo.findAll());
		return "principal";
	}
}
