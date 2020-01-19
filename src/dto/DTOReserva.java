package dto;

import java.io.Serializable;

public class DTOReserva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idReserva;
	private int numPasajeros;
	private String fecha;
	
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "DTOReserva [idReserva=" + idReserva + ", numPasajeros=" + numPasajeros + ", fecha=" + fecha + "]";
	}
	
	
	
	
}
