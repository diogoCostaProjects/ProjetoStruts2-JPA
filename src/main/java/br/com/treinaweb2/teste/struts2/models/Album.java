package br.com.treinaweb2.teste.struts2.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name="ALB_ALBUNS")
public class Album implements Serializable{

	private static final long serialVersionUID = -5980418418274541816L;
	
	@Id
	@GeneratedValue 
	@Column (name="ALB_ID")
	private int id;
	
	@Column (name="ALB_NOME")
	private String nome;
	
	@Column (name="ALB_ANO_LANCAMENTO")
	private int ano;

	/* Desta maneira mapeia a entidade forte do relacionamento, no caso o Album 
	 * por conter v�rias m�sicas, por isso uma para muitas (OneToMany), no caso um �lbum para muitas m�sicas 
	 * o Cascade aplica altera��es nas  m�sicas de acordo com o que acontecer nos �lbuns, e o fetch type setado como EAGER faz com que 
	 * o JPA toda vez que traga um �lbum, carregue todas as m�sicas relacionadas aquele �lbum usando JOIN  */
	
	@OneToMany(cascade = CascadeType.MERGE,  fetch = FetchType.EAGER, mappedBy = "album") 
	//@JoinColumn(name="ALB_ID") // coluna que sera usada como foreign key, exportada de album para m�sica
	private List<Musica> musicas;
			
	
	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
