package com.model;

public class Visitante {

	private int id;
	private String nome, email, mensagem, formaContato, periodo;
	private long telefone;
	
	public Visitante() {
		
	}
	
	public Visitante(int id, String nome, String email, long telefone,
					 String mensagem, String formaContato, String periodo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mensagem = mensagem;
		this.formaContato = formaContato;
		this.periodo = periodo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getFormaContato() {
		return formaContato;
	}

	public void setFormaContato(String formaContato) {
		this.formaContato = formaContato;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
}
