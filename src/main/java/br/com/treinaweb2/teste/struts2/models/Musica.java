package br.com.treinaweb2.teste.struts2.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MUS_MUSICAS")
public class Musica implements Serializable {

	private static final long serialVersionUID = 6725145587975801229L;

	@Id
	@GeneratedValue
	@Column(name = "MUS_ID")
	private int id;

	@Column(name = "MUS_NOME")
	private String nome;

	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "ALB_ID")
	private Album album;

	
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
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

}
