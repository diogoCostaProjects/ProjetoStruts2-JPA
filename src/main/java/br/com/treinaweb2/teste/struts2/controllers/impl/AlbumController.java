package br.com.treinaweb2.teste.struts2.controllers.impl;

import java.util.List;

import br.com.treinaweb2.teste.struts2.controllers.interfaces.Controller;
import br.com.treinaweb2.teste.struts2.dao.impl.AlbumDAO;
import br.com.treinaweb2.teste.struts2.models.Album;

public class AlbumController extends Controller<Album, Integer> {

	public AlbumController() {
		super(new AlbumDAO());

	}

	/*
	 * sort faz a ordenação dentro do array de acordo com parâmetro passado,
	 * utilizando como parâmetro a classe Comparator para implementar qual o
	 * critério de comparação A tipagem dos parâmetros o1 e o2 é inferida pela
	 * máquina virtual, sendo assim, fica a critério da VM descobrir qual o tipo
	 * do parâmetro passado para a expressão Lambda As expressões Lambda podem
	 * ser utilizadas apenas em interfaces funcionais, Interfaces funcionais
	 * utilizam apenas um método a ser implementado
	 */
	@Override
	public String listar() {
		try {
			List<Album> albuns = this.dao.todos();
			albuns.sort((o1, o2) -> { // EXPRESSÃO LAMBDA faz a ordenação por nome
				return o1.getNome().compareTo(o2.getNome());
			});
			this.setModelos(albuns);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;

		}
	}

	@Override
	public String detalhar() {

		try {

			this.setModelo(dao.porId(this.getId()));
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}

	}

	@Override
	public String inserir() {

		try {
			dao.inserir(getModelo());
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	@Override
	public String prepararAlterar() {
		try {
			Album album = dao.porId(getId());
			setModelo(album);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	@Override
	public String alterar() {
		try {
			dao.atualizar(getModelo());
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	@Override
	public String deletar() {
		try {
			Album album = dao.porId(getId());
			dao.deletar(album);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

}
