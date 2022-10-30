package com.reclutamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reclutamiento.model.Empleado;
import com.reclutamiento.model.PerfilPuesto;
import com.reclutamiento.model.repository.EmpleadoRepository;
import com.reclutamiento.model.repository.UnidadOrgRepository;

@Controller
public class EmpleadoController {
	@Autowired
	private UnidadOrgRepository uoRepo;
	@Autowired
	private EmpleadoRepository eRepo;
	@GetMapping("/cargarEmpleado")
	public String abrirEmpleado(Model model) {
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		return "mantEmpleado";
	}
	@PostMapping("/grabarEmpleado")
	public String grabarEmpleado(@ModelAttribute Empleado empleado, Model model) {
		try {
			eRepo.save(empleado);
			model.addAttribute("clase", "alert alert-success");
			model.addAttribute("mensaje", "Empleado registrado");
		} catch (Exception e) {
			model.addAttribute("clase", "alert alert-danger");
			model.addAttribute("mensaje", "Error al registrar el Empleado");
			model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		}
		return "mantEmpleado";
	}
	@PostMapping("/buscarEmpleado")
	public String BuscarEmpleado(@ModelAttribute Empleado e, Model model) {
		
		model.addAttribute("empleado", eRepo.findById(e.getId_empleado()));
		model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		return "mantEmpleado";
	}
	@PostMapping("/eliminarEmpleado")
	public String EliminarEmpleado(@ModelAttribute Empleado e, Model model) {
		eRepo.deleteById(e.getId_empleado());
		model.addAttribute("lstEmp", eRepo.findAll());
		return "mantEmpleado";
	}
}
