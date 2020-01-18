package service;

import java.util.ArrayList;
import java.util.Date;

import dao.DBManager;
import gateways.IAerolineaGw;
import gateways.IPagoGw;
import jdo.InformePago;
import jdo.Reserva;
import jdo.Usuario;
import jdo.Vuelo;

public class RegisterService {
private static RegisterService instance;
	
	private RegisterService() { }
	
	public static RegisterService getInstance() {
		if (instance == null) {
			instance = new RegisterService();
		}
	
		return instance;
	}
	
	public void registro(Usuario usuario, Vuelo vuelo, String nombres, String authType, String idCuenta) {
		ArrayList<String> goodData = new ArrayList<String>();
		Date d = new Date();
		for(int i = 0; i<nombres.split(";").length; i++) {
			goodData.add(nombres.split(";")[i]);
		}
		IAerolineaGw agw = Factory.getInstance().createAerolineaGw(vuelo.getAerolinea());
		IPagoGw pgw = Factory.getInstance().createPagoGw(authType);
		
		agw.reservarVuelo(vuelo.getIdVuelo(), goodData.size());
		
		pgw.pagar(idCuenta, vuelo.getPrecio()*goodData.size());
		
		InformePago ip = new InformePago();
		ip.setCoste(vuelo.getPrecio()*goodData.size());
		ip.setFecha(d.toString());
		ip.setMetodoPago(authType);
		ip.setIdCuenta(idCuenta);
		DBManager.getInstance().guardarInforme(ip);
		
		Reserva r = new Reserva();
		r.setNumPasajeros(goodData.size());
		r.setNombrePasajeros(nombres);
		r.setFecha(d.toString());
		r.setUsuario(usuario);
		r.setVuelo(vuelo);
		DBManager.getInstance().guardarReserva(r);
	}

}
