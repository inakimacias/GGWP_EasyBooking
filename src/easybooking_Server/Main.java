package easybooking_Server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class Main {

	public static void main(String[] args) {
		
		// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		// Persistence Manager
		PersistenceManager pm = null;
		//Transaction to group DB operations
		Transaction tx = null;		
		
		Date salidaVuelo = new Date();
		Date llegadaVuelo = new Date();
		Aerolinea aerolineaIberia = new Aerolinea("IBR", "Iberia");
		Aeropuerto aeropuertoLoiu = new Aeropuerto("Loiu");
	    Aeropuerto aeropuertoMunich = new Aeropuerto("Munich");
	    Vuelo vuelo = new Vuelo(0001, aerolineaIberia, salidaVuelo, llegadaVuelo, 120, 60, aeropuertoLoiu, aeropuertoMunich);	
	    Usuario elDani = new Usuario("danaso@opendeusto.es", aeropuertoLoiu);
	    String[] nombres = {"Dani","Ruben","Inaki","Alberto"};
	    
	    Reserva reservaDani = new Reserva("888", 4, nombres, salidaVuelo);
	    
		//GUARDADO DE DATOS
		//GUARDADO DE DATOS
		//GUARDADO DE DATOS
		//GUARDADO DE DATOS
		try {			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();	
			
			tx.begin();
			
			pm.makePersistent(user1);
			pm.makePersistent(user2);			
			
			tx.commit();			
			
		} catch (Exception ex) {
			System.err.println("Error guardando datos " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
				// ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
			}
		}
		
		//SELECCIONAR DATOS
		//SELECCIONAR DATOS
		//SELECCIONAR DATOS
		//SELECCIONAR DATOS
		try {
			System.out.println("- Retrieving accounts with balace > 200.0 using a 'Query'...");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Query<Account> query = pm.newQuery(Account.class);
			query.setFilter("balance > 200.0");
			
			@SuppressWarnings("unchecked")
			List<Account> accounts = (List<Account>) query.execute();

			//End the transaction
			tx.commit();
			
			for (Account account : accounts) {
				System.out.println("  -> " + account.getUser().getFullName() + " - " + account.getBankName());
			}
		} catch (Exception ex) {
			System.err.println(" $ Error retrieving accounts using a 'Query': " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		//BORRADO DE DATOS
		//BORRADO DE DATOS
		//BORRADO DE DATOS
		//BORRADO DE DATOS
		try {			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Query<User> query = pm.newQuery(User.class);
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();
			
			for (User user : users) {
				System.out.println("  -> Retrieved user: " + user.getFullName());
				System.out.println("     + Removing user from the addresses ... ");
				user.removeUserFromAddresses();
			}
			
			//End the transaction
			tx.commit();
		} catch (Exception ex) {
			System.err.println(" $ Error deleting 'User->Address' relation: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}

	}

}
