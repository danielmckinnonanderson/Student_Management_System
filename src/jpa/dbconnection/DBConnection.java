package jpa.dbconnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DBConnection {
	protected EntityManagerFactory emf = null;
	protected EntityManager em = null;
	private String pName = "SMS";
	
	public void connect() {
		this.emf = Persistence.createEntityManagerFactory(pName);
		this.em = emf.createEntityManager();
	}
	
	public void disconnect() {
		if (this.em != null) {
			em.close();
		}
		if (this.emf != null) {
			emf.close();
		}
	}
}