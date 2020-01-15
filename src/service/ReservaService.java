package service;

import data.jdo.Reserva;
import db.dao.DBManager;

public class ReservaService {
	
	private static ReservaService instance;
	
	private ReservaService() { }
	
	public static ReservaService getInstance() {
		if (instance == null) {
			instance = new ReservaService();
		}
	
		return instance;
	}
	
	public Reserva reservar(String idReserva) {
		Reserva reserva = DBManager.getInstance().getReserva(idReserva);
		
		return reserva;
		
	}

}
