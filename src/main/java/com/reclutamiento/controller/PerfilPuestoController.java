package com.reclutamiento.controller;

import java.io.OutputStream;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reclutamiento.model.PerfilPuesto;
import com.reclutamiento.model.repository.PerfilPuestoRepository;
import com.reclutamiento.model.repository.RolRepository;
import com.reclutamiento.model.repository.UnidadOrgRepository;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class PerfilPuestoController {
	
	@Autowired
	private UnidadOrgRepository uoRepo;
	@Autowired
	private PerfilPuestoRepository ppRepo;
	@Autowired
	private DataSource dataSource; // java.sql
	@Autowired
	private ResourceLoader resourceLoader;
	
	@GetMapping("/listarPerPue")
	public String listarPerfilPuesto(Model model) {
		model.addAttribute("lstPerPue", ppRepo.findAll());
		return "perfilesPuesto";
	}
	
	@GetMapping("/cargarPerPue")
	public String abrirPerfilPuesto(Model model) {
		model.addAttribute("perfilPuesto", new PerfilPuesto());
		model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		return "mantPerPue";
	}
	@PostMapping("/grabarPerPue")
	public String grabarPerfilPuesto(@ModelAttribute PerfilPuesto perfilPuesto, Model model) {
		try {
			ppRepo.save(perfilPuesto);
			model.addAttribute("clase", "alert alert-success");
			model.addAttribute("mensaje", "La operacion fue un exito");
			model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		} catch (Exception e) {
			model.addAttribute("clase", "alert alert-danger");
			model.addAttribute("mensaje", "Ocurrio un error en la operacion");
			model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		}
		return "mantPerPue";
	}
	@PostMapping("/buscarPerfil")
	public String buscarPerfilP(@ModelAttribute PerfilPuesto p, Model model) {
		model.addAttribute("perfilPuesto", ppRepo.findById(p.getClave_perfil()));
		model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		return "mantPerPue";
	}
	@PostMapping("/eliminarPerfil")
	public String eliminarPerfilP(@ModelAttribute PerfilPuesto p, Model model){
		try {
			ppRepo.deleteById(p.getClave_perfil());
			model.addAttribute("mensaje", "Se elimino correctamente");
			model.addAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Este registro tiene un vinculo en otra parte");
			model.addAttribute("clase", "alert alert-danger");
		}
		model.addAttribute("lstPerPue", ppRepo.findAll());
		return "perfilesPuesto";
	}
	@GetMapping("/carConsPerPue")
	public String cargarReportePerPue(Model model) {
		model.addAttribute("perfilPuesto", new PerfilPuesto());
		model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		return "consultaPerPue";
	}
	@PostMapping("/consPerPue")
	public String realizarConsPerPue(@ModelAttribute PerfilPuesto perfilPuesto, HttpServletResponse response) {
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:static/reportes/reportePerPue.jasper").getURI().getPath();
			HashMap parametros = new HashMap<>();
			parametros.put("unidadOrg", perfilPuesto.getId_uo());
			parametros.put("turnoPerPue", perfilPuesto.getTurno());
			parametros.put("estudiosPerPue", perfilPuesto.getEstudios());
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, parametros, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "consultaPerPue";
	}
	/*Aún no se usa*/
	/*
	@GetMapping("/reportePerPue")
	public void impReportePerPue(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:static/reportes/reportePerPue.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
