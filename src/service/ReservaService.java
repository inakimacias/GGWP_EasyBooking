package service;

import java.util.ArrayList;

import gateways.IAerolineaGw;
import gateways.IPagoGw;
import jdo.Reserva;
import jdo.Usuario;
import jdo.Vuelo;

public class ReservaService {
	
	private static ReservaService instance;
	
	private ReservaService() { }
	
	public static ReservaService getInstance() {
		if (instance == null) {
			instance = new ReservaService();
		}
	
		return instance;
	}
	
	public void reservar(Usuario usuario, Vuelo vuelo, ArrayList<String> nombres, String authType, String idCuenta) {
		IAerolineaGw agw = Factory.getInstance().createAerolineaGw(vuelo.getAerolinea());
		IPagoGw pgw = Factory.getInstance().createPagoGw(authType);
		agw.reservarVuelo(vuelo.getIdVuelo(), nombres.size());
		pgw.pagar(idCuenta, vuelo.getPrecio()*nombres.size());
		Reserva r = new Reserva();
	}

}
