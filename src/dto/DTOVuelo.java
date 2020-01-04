package dto;

import jdo.Aerolinea;
import jdo.Aeropuerto;

public class DTOVuelo {

private String idVuelo = null;
	
	private Aerolinea Aerolinea;
	private Aeropuerto aeropuertoDestino;
	private Aeropuerto aeropiuertoOrigen;
	
	
	public String getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}
	public Aerolinea getAerolinea() {
		return Aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		Aerolinea = aerolinea;
	}
	public Aeropuerto getAeropuertoDestino() {
		return aeropuertoDestino;
	}
	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}
	public Aeropuerto getAeropiuertoOrigen() {
		return aeropiuertoOrigen;
	}
	public void setAeropiuertoOrigen(Aeropuerto aeropiuertoOrigen) {
		this.aeropiuertoOrigen = aeropiuertoOrigen;
	}	
}
