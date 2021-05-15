package com.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Visitante;
import com.model.VisitanteService;

@Controller
@ComponentScan("com.model")
public class SiteController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/")
	public String home() {
		return "index"; 
	}
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre"; 
	}
	
	@GetMapping("/contato")
	public String contato(Model model) {
		model.addAttribute("visitante", new Visitante());
		return "contato";
	}
	
	@PostMapping("/visitante")
	public String postVisitante(@ModelAttribute Visitante vi, Model model) {
		VisitanteService vs = context.getBean(VisitanteService.class);
		vs.inserirVisitante(vi);
		return "formsucesso";
	}
	
	@GetMapping("/projetos")
	public String projetos() {
		return "projetos"; 
	}
}
