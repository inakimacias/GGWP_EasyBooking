package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import jdo.InformePago;
import jdo.Reserva;
import jdo.Usuario;
import jdo.Vuelo;

public class DBManager {
	
	private static Logger LOGGER;
	private static DBManager instance;
	private PersistenceManagerFactory pmf = null;
	
	public DBManager() {
		BasicConfigurator.configure();
		LOGGER = Logger.getLogger("Logger");
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");	
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
			instance.initializeData();
		}		
		
		return instance;
	}
	
	private void initializeData() {
		System.out.println(" * Initializing data base");
		//Create Sample data
		Usuario dani = new Usuario();
		dani.setEmail("daniel@gmail.com");

		Usuario inaki = new Usuario();
		inaki.setEmail("inaki@gmail.com");
		
		Usuario ruben = new Usuario();
		ruben.setEmail("ruben@gmail.com");
		
		Usuario alberto = new Usuario();
		alberto.setEmail("alberto@gmail.com");
		
		try {
			//Store users in DB
			DBManager.getInstance().guardarUsuario(dani);
			DBManager.getInstance().guardarUsuario(inaki);
			DBManager.getInstance().guardarUsuario(ruben);
			DBManager.getInstance().guardarUsuario(alberto);
		} catch (Exception ex) {
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public void guardarUsuario(Usuario u) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();	
		try {
			tx.begin();
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			LOGGER.error("Error guardando datos " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) tx.rollback();
			if (pm != null && !pm.isClosed()) pm.close();
		}
	}
	
	public void guardarReserva(Reserva r) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();	
		try {
			tx.begin();
			pm.makePersistent(r);
			tx.commit();
		} catch (Exception ex) {
			LOGGER.error("Error guardando datos " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) tx.rollback();
			if (pm != null && !pm.isClosed()) pm.close();
		}
	}
	
	public void guardarInforme(InformePago i) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();	
		try {
			tx.begin();
			pm.makePersistent(i);
			tx.commit();
		} catch (Exception ex) {
			LOGGER.error("Error guardando datos " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) tx.rollback();
			if (pm != null && !pm.isClosed()) pm.close();
		}
	}
	
	public List<Usuario> getAllUsers() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction(); 
		ArrayList<Usuario> users = new ArrayList<>();

		try {
			System.out.println("  * Querying users");
			tx.begin();
			@SuppressWarnings("unchecked")
			Query<Usuario> query1 = pm.newQuery("SELECT FROM "+Usuario.class.getName());
			for(Usuario user : query1.executeList()) {
				users.add(user);
			}
			
			tx.commit();
			
		} catch (Exception ex) {
			System.out.println("  $ Error querying users: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return users;
	}
	
	public Usuario getUser(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Usuario user = null; 

		try {
			System.out.println("  * Querying a User by email: " + email);
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + email + "'");
			query.setUnique(true);
			user = (Usuario) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return user;
	}
	
	public Reserva getReserva(String idReserva) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Reserva reserva = null; 

		try {
			System.out.println("  * Querying a Reserva by idReserva: " + idReserva);
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Vuelo.class.getName() + " WHERE idReserva == '" + idReserva + "'");
			query.setUnique(true);
			reserva = (Reserva) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Reserva: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return reserva;
	}
	
	public Reserva getInformePago(String idInformePago) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Reserva reserva = null; 

		try {
			System.out.println("  * Querying a Reserva by idReserva: " + idInformePago);
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Vuelo.class.getName() + " WHERE idReserva == '" + idInformePago + "'");
			query.setUnique(true);
			reserva = (Reserva) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Reserva: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return reserva;
	}
}