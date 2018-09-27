package br.com.treinaweb2.teste.struts2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.treinaweb2.teste.struts2.dao.interfaces.IDAOGenerico;
import br.com.treinaweb2.teste.struts2.models.Album;

public class AlbumDAO implements IDAOGenerico<Album, Integer>{

	@SuppressWarnings("unchecked")// ignora o cast na linha 23
	@Override
	public List<Album> todos() {
		List<Album> albuns= null;
		/*Cria a SessionFactory que é uma fábrica de conexões com o banco de dados 
		 * ou fábrica de Sessions no caso
		 * depois abre a sessão com o método openSession()*/
		/*SessionFactory sf = HibernateSessionFactoryUtils.getSessionFactory();
		Session session = sf.openSession();
		albuns = (List<Album>) session.createQuery("from Album").list();
		session.close();*/
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TreinaWebTesteJPA"); // carrega configurações do banco pela PU
		EntityManager entityManager = entityManagerFactory.createEntityManager(); // abre conexão com banco 
		albuns = entityManager.createQuery("from Album").getResultList(); // retorna uma lista de acordo com JPQL
		entityManager.close(); // fecha conexão 
		entityManagerFactory.close(); // fecha fábrica de conexões e de configurações com bd
		return albuns;
	}

	@Override
	public Album porId(Integer id) {
		Album album = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TreinaWebTesteJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		album = entityManager.find(Album.class,id); // Album.class especifica que é uma classe a ser pesquisada e o id especifica o indice da pesquisa
		entityManager.close();
		entityManagerFactory.close();
		return album;
	}

	@Override
	public void inserir(Album modelo) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TreinaWebTesteJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(modelo);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public void atualizar(Album modelo) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TreinaWebTesteJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(modelo);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public void deletar(Album modelo) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TreinaWebTesteJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		modelo = entityManager.merge(modelo); // Torna a entidade Atatched para que o JPA tenha dominio novamente e possa manusear.
		entityManager.remove(modelo);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}

	}
