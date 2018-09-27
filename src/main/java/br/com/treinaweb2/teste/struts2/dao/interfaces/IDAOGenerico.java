package br.com.treinaweb2.teste.struts2.dao.interfaces;

import java.util.List;

public interface IDAOGenerico<M,K> /* parametros da interface que dizem qual ser� o dao criado e a chave da classe
especificando qual ser� o tipo int ou String etc..  */ {

	List<M> todos();
	M porId(Integer id);
	void inserir (M modelo);
	void atualizar (M modelo);
	void deletar (M modelo);
	
	/* Ap�s passado como par�metro entre "<>" atrav�s de Generics, 
	 * quando for implementada a interface automaticamente define 
	 * os par�metros de acordo com o que for especificado entre <>
	*/ 
}
