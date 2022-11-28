package com.reclutamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reclutamiento.model.Memorandum;
import com.reclutamiento.model.repository.MemorandumRepository;
import com.reclutamiento.model.repository.ReqCasRepository;

@Controller
public class MemorandumController {
	@Autowired
	private MemorandumRepository mmRepo;
	@Autowired
	private ReqCasRepository rcRepo;
	
	@GetMapping("/cargarMemoCas")
	public String abrirMemoCas(Model model) {
		model.addAttribute("memorandum", new Memorandum());
		return "memoCas";
	}
	
	
	@GetMapping("/memo")
	public String mostrarPagMemorandums(Model model) {
		model.addAttribute("lstMemo", mmRepo.findAll());
		return "verMemorandums";
	}
	
	
	
	
	
}
