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
		
		InformePago informe = new InformePago("AER", 50, null, "");
		InformePago informe2 = new InformePago("BBB", 100, null, "");
		Aerolinea aerolineaIberia = new Aerolinea("IBR");
		Aerolinea aerolineaRyanair = new Aerolinea("RA");
		Aeropuerto aeropuertoLoiu = new Aeropuerto("Loiu");
	    Aeropuerto aeropuertoMunich = new Aeropuerto("Munich");
	    Aeropuerto aeropuertoMadrid = new Aeropuerto("Madrid");
	    Vuelo vuelo = new Vuelo("PAT", aerolineaIberia.getIdAerolinea(), aeropuertoLoiu.getNombreAeropuerto(), aeropuertoMunich.getNombreAeropuerto());
	    Vuelo vuelo2 = new Vuelo("AOP", aerolineaRyanair.getIdAerolinea(), aeropuertoMadrid.getNombreAeropuerto(), aeropuertoLoiu.getNombreAeropuerto());
	    Usuario elDani = new Usuario("danaso@opendeusto.es", aeropuertoLoiu);
	    Usuario elCorno = new Usuario("elCorno@gmail.com", aeropuertoMunich);
	    String[] nombres = {"Dani","Ruben","Inaki","Alberto"};
	    
	    Reserva reservaDani = new Reserva("888", 4, nombres, new Date(), elDani.getEmail(), vuelo.getIdVuelo(), informe.getIdInformePago());
	    Reserva reservaCorno = new Reserva("666", 4, nombres, new Date(), elCorno.getEmail(), vuelo2.getIdVuelo(), informe2.getIdInformePago());
	    
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
			pm.makePersistent(informe);
			pm.makePersistent(informe2);
			pm.makePersistent(aerolineaRyanair);
			pm.makePersistent(aeropuertoMunich);
			pm.makePersistent(vuelo2);
			pm.makePersistent(reservaCorno);
			
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
			Query<Usuario> query1 = pm.newQuery(Usuario.class);
			Query<Aerolinea> query2 = pm.newQuery(Aerolinea.class);
			
			@SuppressWarnings("unchecked")
			List<Aeropuerto> aeropuertos = (List<Aeropuerto>) query.execute();
			@SuppressWarnings("unchecked")
			List<Usuario> usuarios = (List<Usuario>) query1.execute();
			@SuppressWarnings("unchecked")
			List<Aerolinea> aerolineas = (List<Aerolinea>) query2.execute();

			//End the transaction
			tx.commit();
			
			System.out.println(" - Todos los aeropuertos guardados en la BD");
			
			for (Aeropuerto aeropuerto : aeropuertos) {
				System.out.println("  -> " + aeropuerto.getNombreAeropuerto());
			}
			
			System.out.println(" - Todos los usuarios guardados en la BD");
			
			for (Usuario usuario : usuarios) {
				System.out.println("  -> " + usuario.getEmail());
			}
			
			System.out.println(" - Todas las aerolineas en la BD");
			
			for (Aerolinea aerolinea : aerolineas) {
				System.out.println("  -> " + aerolinea.getIdAerolinea());
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

			System.out.println(" - Borrar todos los usuarios de BD");
			
			System.out.println( query.deletePersistentAll() + "' usuarios borrados de la BD.");
			
			//End the transaction
			tx.commit();
			System.out.println(" - Datos borrados");
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

			System.out.println(" - Cambiando codigo aerolinea Iberia de IBR  -> AEO ");
			
			aerolineaIberia.setIdAerolinea("AEO");
			
			pm.makePersistent(aerolineaIberia);
			
			//End the transaction
			tx.commit();
			System.out.println(" - Datos actualizados");
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
