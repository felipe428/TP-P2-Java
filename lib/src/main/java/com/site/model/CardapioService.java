package com.site.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardapioService {

	@Autowired
	CardapioDAO cdao;
	
	public void insert(Cardapio card) {
	    cdao.insert(card);
	  }
	  
	  public Map<String, Object> getCardapio(int id) {
		  return cdao.getCardapio(id);
	  }
	  
	  public List<Map<String, Object>> getPizzas() {
	      return cdao.getPizzas();
	  }
	  
	  public void deleteCardapio(int id) {
		  cdao.deleteCardapio(id);
	  }
	  
	  public void updateCardapio(int id, Cardapio card) {
		  cdao.updateCardapio(id, card);
	  }
}
