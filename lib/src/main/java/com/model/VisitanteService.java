package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitanteService {

	@Autowired
	VisitanteDAO vdao;
	
	public void inserirVisitante(Visitante v) {
		vdao.inserirVisitante(v);
	}
}
