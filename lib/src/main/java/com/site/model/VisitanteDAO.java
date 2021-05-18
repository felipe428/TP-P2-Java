package com.site.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VisitanteDAO {

	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirVisitante(Visitante visitante) {
		String sql = "INSERT INTO visitante(nome,email,telefone,mensagem,formaContato,periodo)" +
	                 " VALUES (?,?,?,?,?,?)";
		Object[] obj = new Object[6];
		obj[0] = visitante.getNome();
		obj[1] = visitante.getEmail();
		obj[2] = visitante.getTelefone();
		obj[3] = visitante.getMensagem();
		obj[4] = visitante.getFormaContato();
		obj[5] = visitante.getPeriodo();
		jdbc.update(sql, obj);
	}
}
