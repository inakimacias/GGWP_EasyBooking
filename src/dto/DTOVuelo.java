package dto;

import java.io.Serializable;

public class DTOVuelo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idVuelo;
	private String salidaFecha;
	private String llegadaFecha;
	private int asientosVacantes;
	private String aerolinea;
	private String aeropuertoDestino;
	private String aeropuertoOrigen;
	private int precio;
	
	public String getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}
	public String getSalidaFecha() {
		return salidaFecha;
	}
	public void setSalidaFecha(String salidaFecha) {
		this.salidaFecha = salidaFecha;
	}
	public String getLlegadaFecha() {
		return llegadaFecha;
	}
	public void setLlegadaFecha(String llegadaFecha) {
		this.llegadaFecha = llegadaFecha;
	}
	public int getAsientosVacantes() {
		return asientosVacantes;
	}
	public void setAsientosVacantes(int asientosVacantes) {
		this.asientosVacantes = asientosVacantes;
	}
	public String getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	public String getAeropuertoDestino() {
		return aeropuertoDestino;
	}
	public void setAeropuertoDestino(String aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}
	public String getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}
	public void setAeropuertoOrigen(String aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "DTOVuelo [idVuelo=" + idVuelo + ", salidaFecha=" + salidaFecha + ", llegadaFecha=" + llegadaFecha
				+ ", asientosVacantes=" + asientosVacantes + ", aerolinea=" + aerolinea + ", aeropuertoDestino="
				+ aeropuertoDestino + ", aeropuertoOrigen=" + aeropuertoOrigen + ", precio=" + precio + "]";
	}
	
	
	
	
}
