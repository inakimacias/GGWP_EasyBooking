package service;

import java.util.ArrayList;
import java.util.Date;

import assemblers.Assembler;
import dao.DBManager;
import dto.DTOUsuario;
import dto.DTOVuelo;
import gateways.IAerolineaGw;
import gateways.IPagoGw;
import jdo.InformePago;
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
	
	public void reservar(DTOUsuario DTOusuario, DTOVuelo DTOvuelo, String nombres, String authType, String idCuenta) {
		Usuario usuario = DBManager.getInstance().getUser(DTOusuario.getEmail());
		Vuelo vuelo = Assembler.getInstance().getDomainObject(DTOvuelo);
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
