package com.reclutamiento.controller;

import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reclutamiento.model.Empleado;
import com.reclutamiento.model.PerfilPuesto;
import com.reclutamiento.model.repository.EmpleadoRepository;
import com.reclutamiento.model.repository.UnidadOrgRepository;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class EmpleadoController {
	@Autowired
	private UnidadOrgRepository uoRepo;
	@Autowired
	private EmpleadoRepository eRepo;
	@Autowired
	private DataSource dataSource; // java.sql
	@Autowired
	private ResourceLoader resourceLoader;
	
	@GetMapping("/monstrarPagEmpleado")
	public String mostrarPaginaEmpleado(Model model) {
		model.addAttribute("lstEmp", eRepo.findAll());
		/*model.addAttribute("pagina", "empleados");
		model.addAttribute("modulo", "empleado");*/
		return "empleados";
	}
	
	@GetMapping("/cargarEmpleado")
	public String abrirEmpleado(Model model) {
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("lstUnidadesOrganicas", uoRepo.findAll());
		/*model.addAttribute("pagina", "mantEmpleado");
		model.addAttribute("modulo", "mantEmpleado");*/
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
		try {
			eRepo.deleteById(e.getId_empleado());
			model.addAttribute("mensaje", "Se elimino correctamente");
			model.addAttribute("clase", "alert alert-success");
		} catch (Exception e2) {
			model.addAttribute("mensaje", "Este registro tiene un vinculo en otra parte");
			model.addAttribute("clase", "alert alert-danger");
		}
		
		model.addAttribute("lstEmp", eRepo.findAll());
		return "empleados";
	}
	
	@GetMapping("/rSexo")
	public void reporteSexo(@ModelAttribute PerfilPuesto perfilPuesto, HttpServletResponse response) {
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:static/reportes/grfSexo.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/rUO")
	public void reporteUnidadOrg(@ModelAttribute PerfilPuesto perfilPuesto, HttpServletResponse response) {
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:static/reportes/grfUo.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
