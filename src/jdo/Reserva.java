package jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {	

	@PrimaryKey
	private String idReserva;
	private int numPasajeros;
	private String nombrePasajeros;
	private String fecha;
	
	private Usuario usuario;
	private Vuelo vuelo;
	private InformePago informePago;
	
	public Reserva() {
	}

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

	public String getNombrePasajeros() {
		return nombrePasajeros;
	}

	public void setNombrePasajeros(String nombrePasajeros) {
		this.nombrePasajeros = nombrePasajeros;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public InformePago getInformePago() {
		return informePago;
	}

	public void setInformePago(InformePago informePago) {
		this.informePago = informePago;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
