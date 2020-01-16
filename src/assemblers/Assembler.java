package assemblers;

import dto.*;
import jdo.*;

public class Assembler {

	private static Assembler instance = new Assembler();
	
	public static Assembler getInstance() {
		return instance;
	}

	public DTOUsuario assemble(Usuario usuario) {
		DTOUsuario dto = new DTOUsuario();
		dto.setEmail(usuario.getEmail());
		dto.setAerPred(usuario.getPredAirp());
		return dto;
	}
	public DTOVuelo assemble(Vuelo vuelo) {
		DTOVuelo dto = new DTOVuelo();
		dto.setIdVuelo(vuelo.getIdVuelo());
		dto.setSalidaFecha(vuelo.getSalidaFecha());
		dto.setLlegadaFecha(vuelo.getLlegadaFecha());
		dto.setAsientosVacantes(vuelo.getAsientosVacantes());
		dto.setAerolinea(vuelo.getAerolinea());
		dto.setAeropuertoOrigen(vuelo.getAeropuertoOrigen());
		dto.setAeropuertoDestino(vuelo.getAeropuertoDestino());
		dto.setPrecio(vuelo.getPrecio());
		return dto;
	}
	public DTOReserva assemble(Reserva reserva) {
		DTOReserva dto = new DTOReserva();
		dto.setIdReserva(reserva.getIdReserva());
		dto.setNumPasajeros(reserva.getNumPasajeros());
		dto.setFecha(reserva.getFecha());
		return dto;
	}
	public DTOInformePago assemble(InformePago ip) {
		DTOInformePago dto = new DTOInformePago();
		dto.setIdInformePago(ip.getIdInformePago());
		dto.setIdCuenta(ip.getIdCuenta());
		dto.setFecha(ip.getFecha());
		dto.setCoste(ip.getCoste());
		dto.setMetodoPago(ip.getMetodoPago());
		return dto;
	}
}
