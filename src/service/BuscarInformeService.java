package service;

import java.util.ArrayList;

import assemblers.Assembler;
import dao.DBManager;
import dto.DTOInformePago;
import dto.DTOReserva;
import jdo.Reserva;

public class BuscarInformeService {
	
	private static BuscarInformeService instance;
	private BuscarInformeService() { }
	
	public static BuscarInformeService getInstance() {
		if (instance == null) {
			instance = new BuscarInformeService();
		}
	
		return instance;
	}
	
	public DTOInformePago buscarInforme(DTOReserva r) {
		DTOInformePago informe = new DTOInformePago();
		ArrayList<Reserva> todasLasReservas = DBManager.getInstance().getAllReservas();
		for(int i = 0; i<todasLasReservas.size(); i++) {
			if(todasLasReservas.get(i).getIdReserva().equals(r.getIdReserva())) {
				informe = Assembler.getInstance().assemble(todasLasReservas.get(i).getInformePago());
			}
		}
		return informe;
	}
}
