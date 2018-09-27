package br.com.treinaweb2.teste.struts2.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtils {
	
// m�todo configura conex�o com base no arquivo hibernate.cfg.xml e retorna uma sess�o/conex�o com o BD
	
	public static SessionFactory getSessionFactory(){
		
		return new Configuration().configure().buildSessionFactory();
		
		
	}

}
