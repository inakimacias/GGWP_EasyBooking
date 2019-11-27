package easybooking_Server;

import java.util.Date;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {	

	@PrimaryKey
	private String idReserva = null;
	private int numPasajeros = 0;
	private String[] nombrePasajeros = null;
	private Date fecha = null;
	
	@ForeignKey
	String usuario = null;
	@ForeignKey
	String idVuelo = null;
	@ForeignKey
	String idInformePago = null;
	
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getIdInformePago() {
		return idInformePago;
	}

	public void setIdInformePago(String idInformePago) {
		this.idInformePago = idInformePago;
	}	
}
