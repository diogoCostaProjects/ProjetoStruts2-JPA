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
	 * sort faz a ordena��o dentro do array de acordo com par�metro passado,
	 * utilizando como par�metro a classe Comparator para implementar qual o
	 * crit�rio de compara��o A tipagem dos par�metros o1 e o2 � inferida pela
	 * m�quina virtual, sendo assim, fica a crit�rio da VM descobrir qual o tipo
	 * do par�metro passado para a express�o Lambda As express�es Lambda podem
	 * ser utilizadas apenas em interfaces funcionais, Interfaces funcionais
	 * utilizam apenas um m�todo a ser implementado
	 */
	@Override
	public String listar() {
		try {
			List<Album> albuns = this.dao.todos();
			albuns.sort((o1, o2) -> { // EXPRESS�O LAMBDA faz a ordena��o por nome
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
