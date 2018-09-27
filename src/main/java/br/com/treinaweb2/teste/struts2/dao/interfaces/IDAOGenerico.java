package br.com.treinaweb2.teste.struts2.dao.interfaces;

import java.util.List;

public interface IDAOGenerico<M,K> /* parametros da interface que dizem qual será o dao criado e a chave da classe
especificando qual será o tipo int ou String etc..  */ {

	List<M> todos();
	M porId(Integer id);
	void inserir (M modelo);
	void atualizar (M modelo);
	void deletar (M modelo);
	
	/* Após passado como parâmetro entre "<>" através de Generics, 
	 * quando for implementada a interface automaticamente define 
	 * os parâmetros de acordo com o que for especificado entre <>
	*/ 
}
