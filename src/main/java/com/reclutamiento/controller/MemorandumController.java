package com.reclutamiento.controller;

import com.reclutamiento.model.PerfilPuesto;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reclutamiento.model.Memorandum;
import com.reclutamiento.model.repository.MemorandumRepository;
import com.reclutamiento.model.repository.ReqCasRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemorandumController {
    @Autowired
    private MemorandumRepository mmRepo;
    @Autowired
    private ReqCasRepository rcRepo;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private DataSource dataSource;

    @GetMapping("/memo")
    public String abrirMemoCas(Model model) {
        model.addAttribute("memorandum", new Memorandum());
        return "memoCas";
    }

    @PostMapping("/memo/reporte")
    public void reporte(HttpServletResponse response, @ModelAttribute Memorandum memorandum) {
        response.setHeader("Content-Disposition", "inline;");
        response.setContentType("application/pdf");
        LocalDate fecha = memorandum.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(1);
        Map<String, Object> param = new HashMap<>();
        try {
            param.put("logoRoute", resourceLoader.getResource("classpath:static/reportes/img/MinisLogo.png").getURI().getPath());
            param.put("fecha", DateTimeFormatter.ofPattern("YYYY-MM-dd").format(fecha));
            String ru = resourceLoader.getResource("classpath:static/reportes/memorandum.jasper").getURI().getPath();
            JasperPrint jasperPrint = JasperFillManager.fillReport(ru, param, dataSource.getConnection());
            OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
