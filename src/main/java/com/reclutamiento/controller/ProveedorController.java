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
			model.addAttribute("clase", "alert alert-success");
			model.addAttribute("mensaje", "La operacion fue un exito");
		} catch (Exception e) {
			model.addAttribute("clase", "alert alert-danger");
			model.addAttribute("mensaje", "Ocurrio un error en la operacion");
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
		try {
			repProve.deleteById(p.getCod_Prov());
			model.addAttribute("mensaje", "Se elimino correctamente");
			model.addAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Este registro tiene un vinculo en otra parte");
			model.addAttribute("clase", "alert alert-danger");
		}
		model.addAttribute("lstProve", repProve.findAll());
		return "proveedoresLista";
	}
}
