package easybooking_Server;

import java.util.Date;
import java.util.List;

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
		InformePago informe = new InformePago("AER", 50, null, "");
		Aerolinea aerolineaIberia = new Aerolinea("IBR");
		Aeropuerto aeropuertoLoiu = new Aeropuerto("Loiu");
	    Aeropuerto aeropuertoMunich = new Aeropuerto("Munich");
	    Vuelo vuelo = new Vuelo("PAT", aerolineaIberia.getIdAerolinea(), aeropuertoLoiu.getNombreAeropuerto(), aeropuertoMunich.getNombreAeropuerto());	
	    Usuario elDani = new Usuario("danaso@opendeusto.es", aeropuertoLoiu);
	    String[] nombres = {"Dani","Ruben","Inaki","Alberto"};
	    
	    Reserva reservaDani = new Reserva("888", 4, nombres, salidaVuelo, elDani.getEmail(), vuelo.getIdVuelo(), informe.getIdInformePago());
	    
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
			
			pm.makePersistent(elDani);
			pm.makePersistent(vuelo);
			pm.makePersistent(aeropuertoLoiu);
			pm.makePersistent(aerolineaIberia);
			pm.makePersistent(reservaDani);
			
			tx.commit();
			System.out.println("- Datos guardados en BD");
			
		} catch (Exception ex) {
			System.err.println("Error guardando datos " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		//SELECCIONAR DATOS
		//SELECCIONAR DATOS
		//SELECCIONAR DATOS
		//SELECCIONAR DATOS
		try {
			System.out.println("- Seleccionando aeropuertos usando 'Query'...");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Query<Aeropuerto> query = pm.newQuery(Aeropuerto.class);
			
			@SuppressWarnings("unchecked")
			List<Aeropuerto> aeropuertos = (List<Aeropuerto>) query.execute();

			//End the transaction
			tx.commit();
			
			for (Aeropuerto aeropuerto : aeropuertos) {
				System.out.println("  -> " + aeropuerto.getNombreAeropuerto());
			}
		} catch (Exception ex) {
			System.err.println(" $ Error seleccionando aeropuertos usando 'Query': " + ex.getMessage());
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

			Query<Usuario> query = pm.newQuery(Usuario.class);

			System.out.println( query.deletePersistentAll() + "' usuarios borrados de la BD.");
			
			//End the transaction
			tx.commit();
			System.out.println("Datos borrados");
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
		
		//ACTUALIZAR DATOS
		//ACTUALIZAR DATOS
		//ACTUALIZAR DATOS
		//ACTUALIZAR DATOS
		try {			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			aerolineaIberia.setIdAerolinea("AEO");
			
			pm.makePersistent(aerolineaIberia);
			
			//End the transaction
			tx.commit();
			System.out.println("Datos actualizados");
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
