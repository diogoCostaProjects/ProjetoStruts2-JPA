package br.com.treinaweb2.teste.struts2.controllers.interfaces;

import java.util.List;

import br.com.treinaweb2.teste.struts2.dao.interfaces.IDAOGenerico;

public abstract class Controller<M,K> {
// CLASSE IRÁ SE COMUNICAR COM INTERFACE ATRAVÉS DE JAVABEANS
	
	public static String SUCCESS = "SUCCESS"; // CRIADAS AS DUAS CONSTANTES PARA NÃO PRECISAR CRIAR TODA HORA PARA CADA ACTION
	public static String ERROR = "ERROR";
	
	protected IDAOGenerico<M, K> dao;
	
	protected M modelo;
	protected List<M> modelos;
	protected K id;

	
	
	
	
	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public M getModelo() {
		return modelo;
	}

	public void setModelo(M modelo) {
		this.modelo = modelo;
	}

	public List<M> getModelos() {
		return modelos;
	}

	public void setModelos(List<M> modelos) {
		this.modelos = modelos;
	}

	public Controller(IDAOGenerico<M, K> dao){
		this.dao = dao;
	}
	
	public abstract String listar();
	public abstract String detalhar();
	public abstract String inserir();
	public abstract String alterar();
	public abstract String deletar();
	public abstract String prepararAlterar();
	
}
