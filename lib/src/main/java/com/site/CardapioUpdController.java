package com.site;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.model.Cardapio;
import com.site.model.CardapioService;

@Controller
public class CardapioUpdController {
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/upd/{id}")
    public String updateForm(@PathVariable("id") int id, Model model){
		CardapioService cdao = context.getBean(CardapioService.class);
		Map<String,Object> antigo = cdao.getCardapio(id);
		BigDecimal bd = (BigDecimal)antigo.get("preco");
		Cardapio card = new Cardapio((String)antigo.get("nome"), (String)antigo.get("descricao"), bd.doubleValue());
		model.addAttribute("antigo",card);
		model.addAttribute("id",id);
		return "formcardapioupd";
    }
	
	@PostMapping("/upd/{id}")
	public String update(@PathVariable("id") int id,@ModelAttribute Cardapio card, Model model) {
		CardapioService cdao = context.getBean(CardapioService.class);
		cdao.updateCardapio(id, card);
		return "redirect:/pizzas";
	}
}
