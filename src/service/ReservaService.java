package service;

import dao.DBManager;
import jdo.Reserva;

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
