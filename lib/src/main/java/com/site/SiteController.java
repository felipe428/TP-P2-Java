package com.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
	
	@GetMapping("/")
	public String home() {
		return "index"; 
	}
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre"; 
	}
	
	@GetMapping("/contato")
	public String contato() {
		return "contato"; 
	}
	
	@GetMapping("/projetos")
	public String projetos() {
		return "projetos"; 
	}
}
