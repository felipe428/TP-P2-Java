package com.site.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CardapioDAO{
	@Autowired 
    DataSource dataSource;
    
	JdbcTemplate jdbc;
	
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }
    
    public void insert(Cardapio card) {
        String sql = "INSERT INTO cardapio " +
    "(nome,descricao,preco) VALUES (?,?,?)" ;
        jdbc.update(sql, new Object[]{
        		card.getNome(), card.getDescricao(), card.getPreco()
        });
    }
    
    public Map<String, Object> getCardapio(int id) {
    	String sql = "SELECT * FROM cardapio WHERE cardapio.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> getPizzas() {
    	String sql = "SELECT * FROM cardapio";
    	List<Map<String, Object>> pizzas = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return pizzas;
    }
    
    public void deleteCardapio(int id) {
        String sql = "DELETE FROM cardapio WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void updateCardapio(int id,Cardapio card) {
    	String sql = "UPDATE cardapio SET nome = ?, descricao = ?, preco = ? WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
         		card.getNome(), card.getDescricao(), card.getPreco(),id
         });
    }
}
