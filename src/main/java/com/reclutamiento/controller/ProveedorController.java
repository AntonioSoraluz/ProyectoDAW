package com.reclutamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reclutamiento.model.Empleado;
import com.reclutamiento.model.Proveedor;
import com.reclutamiento.model.repository.ProveedorRepository;

@Controller
public class ProveedorController {

	@Autowired
	private ProveedorRepository repProve;
	
	@GetMapping("/monstrarPagProveedor")
	public String mostrarPaginaProveedor(Model model) {
		model.addAttribute("lstProve", repProve.findAll());
		return "proveedoresLista";
	}
	
	@GetMapping("/cargarProveedor")
	public String abrirProveedor(Model model) {
		model.addAttribute("proveedor", new Proveedor());
		return "mantProveedor";
	}
	@PostMapping("/grabarProveedor")
	public String grabarProveedor(@ModelAttribute Proveedor proveedor, Model model) {
		try {
			repProve.save(proveedor);
			model.addAttribute("claseProve", "alert alert-success");
			model.addAttribute("mensajeProve", "Proveedor registrado");
		} catch (Exception e) {
			model.addAttribute("claseProve", "alert alert-danger");
			model.addAttribute("mensajeProve", "Error al registrar el Proveedor");
		}
		return "mantProveedor";
	}
	
	@PostMapping("/busProvedores")
	public String buscaProvedores(@ModelAttribute Proveedor p,Model model) {
		model.addAttribute("proveedor",repProve.findById(p.getCod_Prov()));
		return "mantProveedor";
	}
	
	@PostMapping("/eliProveedor")
	public String EliProveedor(@ModelAttribute Proveedor p, Model model) {
		repProve.deleteById(p.getCod_Prov());
		model.addAttribute("lstProve", repProve.findAll());
		return "redirect:/monstrarPagProveedor";
	}
	
	
	
}
