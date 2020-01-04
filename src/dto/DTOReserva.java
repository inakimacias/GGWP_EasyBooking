package dto;

import java.util.Date;

public class DTOReserva {

	private String idReserva = null;
	private int numPasajeros = 0;
	private String[] nombrePasajeros = null;
	private Date fecha = null;
	
	
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public int getNumPasajeros() {
		return numPasajeros;
	}
	public void setNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
	}
	public String[] getNombrePasajeros() {
		return nombrePasajeros;
	}
	public void setNombrePasajeros(String[] nombrePasajeros) {
		this.nombrePasajeros = nombrePasajeros;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
