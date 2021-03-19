package jpa.mainrunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SMSRunner {
	public static void main(String [] args) {
		//placeholder
		System.out.println("Working");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMS");
		EntityManager em = emf.createEntityManager();
	}
}
