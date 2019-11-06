package easybooking_Client;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class Main {

	public static void main(String[] args) {
		
		// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		// Persistence Manager
		PersistenceManager pm = null;
		//Transaction to group DB operations
		Transaction tx = null;
		
		try { 
			System.out.println("- Guardado en la BD");
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			
			//Necesitamos tener terminadas todas las relaciones entre las clases para crear las funciones
			
			tx.commit();
			
		} catch (Exception ex) {
			System.err.println("* Exception: " + ex.getMessage());
		}

	}

}
