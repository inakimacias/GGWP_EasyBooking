package easybooking_server;

import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		final Logger LOGGER = Logger.getLogger("Logger");
		// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		// Persistence Manager
		PersistenceManager pm = null;
		//Transaction to group DB operations
		Transaction tx = null;		
		
		MetodoPago metodoPago = new MetodoPago();
		metodoPago.setIdMetPago("");
		
		
		InformePago informe = new InformePago();
		informe.setIdInformePago("AER");
		informe.setCoste(50);
		informe.setFecha(null);
		informe.setMetodoPago(metodoPago);
		
		InformePago informe2 = new InformePago();
		informe.setIdInformePago("BBB");
		informe.setCoste(100);
		informe.setFecha(null);
		informe.setMetodoPago(metodoPago);
		
		Aerolinea aerolineaIberia = new Aerolinea();
		aerolineaIberia.setIdAerolinea("IBR");
		
		Aerolinea aerolineaRyanair = new Aerolinea();
		aerolineaRyanair.setIdAerolinea("RA");
		
		Aeropuerto aeropuertoLoiu = new Aeropuerto();
		aeropuertoLoiu.setNombreAeropuerto("Loiu");
		
	    Aeropuerto aeropuertoMunich = new Aeropuerto();
	    aeropuertoMunich.setNombreAeropuerto("Munich");
	    
	    Aeropuerto aeropuertoMadrid = new Aeropuerto();
	    aeropuertoMadrid.setNombreAeropuerto("Madrid");
	    
	    Vuelo vuelo = new Vuelo();
	    vuelo.setIdVuelo("PAT");
	    vuelo.setAerolinea(aerolineaIberia);
	    vuelo.setAeropiuertoOrigen(aeropuertoLoiu);
	    vuelo.setAeropuertoDestino(aeropuertoMunich);
	       
	    Vuelo vuelo2 = new Vuelo();
	    vuelo2.setIdVuelo("AOP");
	    vuelo2.setAerolinea(aerolineaRyanair);
	    vuelo2.setAeropiuertoOrigen(aeropuertoMadrid);
	    vuelo2.setAeropuertoDestino(aeropuertoLoiu);
	    
	    Usuario elDani = new Usuario();
	    elDani.setEmail("danaso@opendeusto.es");
	    elDani.setPredAirp(aeropuertoLoiu);
	    
	    
	    Usuario elCorno = new Usuario();
	    elCorno.setEmail("elCorno@gmail.com");
	    elCorno.setPredAirp(aeropuertoMunich);
	    
	    String[] nombres = {"Dani","Ruben","Inaki","Alberto"};
	    
	    Reserva reservaDani = new Reserva();
	    reservaDani.setFecha(new Date());
	    reservaDani.setInformePago(informe);
	    reservaDani.setIdReserva("888");
	    reservaDani.setVuelo(vuelo);
	    reservaDani.setNombrePasajeros(nombres);
	    reservaDani.setNumPasajeros(4);
	    reservaDani.setUsuario(elDani);
	    
	    
	    Reserva reservaCorno = new Reserva();
	    reservaCorno.setFecha(new Date());
	    reservaCorno.setInformePago(informe2);
	    reservaCorno.setIdReserva("666");
	    reservaCorno.setVuelo(vuelo2);
	    reservaCorno.setNombrePasajeros(nombres);
	    reservaCorno.setNumPasajeros(4);
	    reservaCorno.setUsuario(elCorno);
	    
	    
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
			pm.makePersistent(elCorno);
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
			
			LOGGER.info("- Datos guardados en BD");
		} catch (Exception ex) {
			LOGGER.error("Error guardando datos " + ex.getMessage());
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
			LOGGER.info("- Seleccionando aeropuertos usando 'Query'...");
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
			
			LOGGER.info(" - Aeropuertos guardados en la BD:");
			for (Aeropuerto aeropuerto : aeropuertos) {
				LOGGER.info("  -> " + aeropuerto.getNombreAeropuerto());
			}
			
			LOGGER.info(" - Usuarios guardados en la BD:");
			for (Usuario usuario : usuarios) {
				LOGGER.info("  -> " + usuario.getEmail());
			}
			
			LOGGER.info(" - Aerolineas en la BD:");
			for (Aerolinea aerolinea : aerolineas) {
				LOGGER.info("  -> " + aerolinea.getIdAerolinea());
			}
			
		} catch (Exception ex) {
			LOGGER.error(" $ Error seleccionando aeropuertos usando 'Query': " + ex.getMessage());
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
			
			LOGGER.info("");
			LOGGER.info(" - Borrando todos los usuarios de BD");
			LOGGER.info(query.deletePersistentAll() + "' usuarios borrados de la BD.");
			//End the transaction
			tx.commit();
			LOGGER.info(" - Datos borrados");
		} catch (Exception ex) {
			LOGGER.error(" $ Error deleting 'User->Address' relation: " + ex.getMessage());
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

			LOGGER.info("");
			LOGGER.info(" - Cambiando codigo aerolinea Iberia de IBR  -> AEO ");
			aerolineaIberia.setIdAerolinea("AEO");
			
			pm.makePersistent(aerolineaIberia);
			
			//End the transaction
			tx.commit();
			LOGGER.info(" - Datos actualizados");
		} catch (Exception ex) {
			LOGGER.error(" $ Error updating  'IBR -> AEO': " + ex.getMessage());
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
