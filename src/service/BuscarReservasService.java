package service;

import java.util.ArrayList;

import assemblers.Assembler;
import dao.DBManager;
import dto.DTOReserva;
import dto.DTOUsuario;
import jdo.Reserva;

public class BuscarReservasService {
	
	private static BuscarReservasService instance;
	private BuscarReservasService() { }
	
	public static BuscarReservasService getInstance() {
		if (instance == null) {
			instance = new BuscarReservasService();
		}
	
		return instance;
	}
	
	public ArrayList<DTOReserva> buscarReservas(DTOUsuario u) {
		ArrayList<DTOReserva> reservas = new ArrayList<DTOReserva>();
		ArrayList<Reserva> todasLasReservas = DBManager.getInstance().getAllReservas();
		for(int i = 0; i<todasLasReservas.size(); i++) {
			if(todasLasReservas.get(i).getUsuario().getEmail().equals(u.getEmail())) {
				reservas.add(Assembler.getInstance().assemble(todasLasReservas.get(i)));
			}
		}
		return reservas;
	}
}
