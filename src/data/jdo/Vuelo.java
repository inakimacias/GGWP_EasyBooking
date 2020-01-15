package data.jdo;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo {
	
	@PrimaryKey
	private String idVuelo = null;
	private Date salidaFecha;
	private Date llegadaFecha;
	private int asientosTotales;
	private int asientosVacantes;
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
	
	public Date getSalidaFecha() {
		return salidaFecha;
	}

	public void setSalidaFecha(Date salidaFecha) {
		this.salidaFecha = salidaFecha;
	}

	public Date getLlegadaFecha() {
		return llegadaFecha;
	}

	public void setLlegadaFecha(Date llegadaFecha) {
		this.llegadaFecha = llegadaFecha;
	}

	public int getAsientosTotales() {
		return asientosTotales;
	}

	public void setAsientosTotales(int asientosTotales) {
		this.asientosTotales = asientosTotales;
	}

	public int getAsientosVacantes() {
		return asientosVacantes;
	}

	public void setAsientosVacantes(int asientosVacantes) {
		this.asientosVacantes = asientosVacantes;
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
