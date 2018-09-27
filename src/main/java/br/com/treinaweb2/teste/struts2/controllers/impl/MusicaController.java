package br.com.treinaweb2.teste.struts2.controllers.impl;

import java.util.List;

import br.com.treinaweb2.teste.struts2.controllers.interfaces.Controller;
import br.com.treinaweb2.teste.struts2.dao.impl.AlbumDAO;
import br.com.treinaweb2.teste.struts2.dao.impl.MusicaDAO;
import br.com.treinaweb2.teste.struts2.dao.interfaces.IDAOGenerico;
import br.com.treinaweb2.teste.struts2.models.Album;
import br.com.treinaweb2.teste.struts2.models.Musica;

public class MusicaController extends Controller<Musica, Integer> {

	private List<Album> albuns;	//usado no combobox, como funciona no JSF para armazenar valores e o id selecionado 
	private int albumId; // captura album selecionado pelo combobox
	private IDAOGenerico<Album, Integer> albumDao = new AlbumDAO(); // Busca albuns do banco para preencher o combobox
	
	public MusicaController() {
		super(new MusicaDAO());

	}
	
	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

	public int getAlbumId() { // retorna o album selecionado no combobox
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	

	@Override
	public String listar() {
		try {
			this.setModelos(this.dao.todos());
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
			Musica musica = getModelo();	
			Album albumSelecionado = albumDao.porId(getAlbumId());
			musica.setAlbum(albumSelecionado);
			dao.inserir(musica);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	public String prepararInserir() {
		try {
			albuns = albumDao.todos();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Override
	public String prepararAlterar() {
		try {
			Musica musica= dao.porId(getId());
			setModelo(musica);
			albuns = albumDao.todos();
			setAlbumId(musica.getAlbum().getId());
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	@Override
	public String alterar() {
		try {
			Musica musica = getModelo();	
			Album albumSelecionado = albumDao.porId(getAlbumId());
			musica.setAlbum(albumSelecionado);
			dao.atualizar(musica);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	@Override
	public String deletar() {
		try {
			Musica musica = dao.porId(getId());
			dao.deletar(musica);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
		

}
