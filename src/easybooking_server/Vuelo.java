package easybooking_server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo {
	
	@PrimaryKey
	private String idVuelo = null;
	
	private Aerolinea Aerolinea;
	private Aeropuerto aeropuertoDestino;
	private Aeropuerto aeropiuertoOrigen;
	
	public Vuelo() {
	}

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
