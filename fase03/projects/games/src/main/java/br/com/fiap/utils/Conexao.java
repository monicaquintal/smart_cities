package br.com.fiap.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexao {
	
	public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("games");
	
	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}
	
}
