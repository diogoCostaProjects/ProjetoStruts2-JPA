package br.com.treinaweb2.teste.struts2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.treinaweb2.teste.struts2.dao.interfaces.IDAOGenerico;
import br.com.treinaweb2.teste.struts2.models.Musica;

public class MusicaDAO implements IDAOGenerico<Musica, Integer>{

	@SuppressWarnings("unchecked")// ignora o cast na linha 23
	@Override
	public List<Musica> todos() {
		List<Musica> musicas= null;
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TreinaWebTesteJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		musicas = entityManager.createQuery("from Musica").getResultList();
		entityManager.close();
		entityManagerFactory.close();
		return musicas;
	}

	@Override
	public Musica porId(Integer id) {
		Musica musica = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TreinaWebTesteJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		musica = entityManager.find(Musica.class,id); // Album.class especifica que � uma classe a ser pesquisada
		entityManager.close();
		entityManagerFactory.close();
		return musica;
	}

	@Override
	public void inserir(Musica modelo) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TreinaWebTesteJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(modelo);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public void atualizar(Musica modelo) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TreinaWebTesteJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(modelo);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public void deletar(Musica modelo) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TreinaWebTesteJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	// para remover a m�sica e necess�rio primeiro desvincular do �lbum, por isso pesquisa-se a m�sica a ser deletada e ap�s seta o �lbum como null, pra n�o ter mais rela��o com nanhum �lbum, pois a JPA n�o permite a exclus�o de uma entidade fraca no relacionamento
		modelo = entityManager.find(Musica.class,modelo.getId()); // Torna a entidade Atatched para que o JPA tenha dominio novamente e possa manusear.
		modelo.setAlbum(null);
		entityManager.remove(modelo);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}

	}
