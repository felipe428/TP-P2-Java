package com.site.acesso;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String exibirCardapio(Usuario usuario) {
		return "login";
	}
	
	@PostMapping("/efetuarLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session) {
		if(usuario.getLogin().equals("admin") && usuario.getSenha().equals("admin")) {
			usuario.setNome("Administrador");
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:/cardapio";
		} else {
			return "redirect:/login";
		}
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
