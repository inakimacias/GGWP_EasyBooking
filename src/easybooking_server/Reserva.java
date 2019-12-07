package easybooking_server;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {	

	@PrimaryKey
	private String idReserva = null;
	private int numPasajeros = 0;
	private String[] nombrePasajeros = null;
	private Date fecha = null;
	
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
}
