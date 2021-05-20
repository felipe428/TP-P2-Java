package com.site;

import java.math.BigDecimal;
import java.util.List;
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
public class CardapioController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/cardapio")
	public String cadastrar(Model model) {
		model.addAttribute("card",new Cardapio());
		return "formcardapio";
	}
	
	@PostMapping("/cardapio")
	public String acao(@ModelAttribute Cardapio card,Model model) {
		model.addAttribute("card",card);
		model.addAttribute("titulo","Cardapio Adicionado Com Sucesso");
		CardapioService cdao = context.getBean(CardapioService.class);
		cdao.insert(card);
		return "cardapiosucesso";
	}
	
	@GetMapping("descr/{id}")
    public String read(@PathVariable("id") int id, Model model){
		CardapioService cdao = context.getBean(CardapioService.class);
		Map<String,Object> cardapio = cdao.getCardapio(id);
		BigDecimal bd = (BigDecimal)cardapio.get("preco");
		Cardapio card = new Cardapio((String)cardapio.get("nome"),(String)cardapio.get("descricao"),bd.doubleValue());
		model.addAttribute("card",card);
		model.addAttribute("titulo","Sabor da Pizza" + id);
		return "cardapiosucesso";
    }
	
	@GetMapping("/pizzas")
	public String listar(Model model) {
		CardapioService cdao = context.getBean(CardapioService.class);
		List<Map<String,Object>> pizzas = cdao.getPizzas();
		model.addAttribute("pizzas",pizzas);
		return "pizzas";
	}
	
	@PostMapping("/apagar/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		CardapioService cdao = context.getBean(CardapioService.class);
		cdao.deleteCardapio(id);
		return "redirect:/pizzas";
	}
	
}
