package mysql;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MysqlSingleton {

	private static EntityManagerFactory emf;
	
	private MysqlSingleton() {
	}
	
	public synchronized static EntityManagerFactory getInstance() {
		if ( emf == null ) {
			emf = Persistence.createEntityManagerFactory("testePU");
		}
		return emf;
	}
	
}
