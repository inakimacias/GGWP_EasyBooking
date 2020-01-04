package dto;

import java.util.Date;

import jdo.Aerolinea;
import jdo.Aeropuerto;

public class DTOVuelo {

	private String idVuelo = null;
	private Date salidaFecha;
	private Date llegadaFecha;
	private int asientosTotales;
	private int asientosVacantes;
	
	
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
	
}
