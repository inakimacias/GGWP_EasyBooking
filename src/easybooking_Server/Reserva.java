package easybooking_Server;

import java.util.Date;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {	

	@PrimaryKey
	String idReserva = null;
	int numPasajeros = 0;
	String[] nombrePasajeros = null;
	Date fecha = null;
	
	@ForeignKey
	String usuario = null;
	@ForeignKey
	String idVuelo = null;
	@ForeignKey
	String idInformePago = null;
	
	public Reserva(String idReserva, int numPasajeros, String[] nombrePasajeros, Date fecha, String usuario,
			String idVuelo, String idInformePago) {
		this.idReserva = idReserva;
		this.numPasajeros = numPasajeros;
		this.nombrePasajeros = nombrePasajeros;
		this.fecha = fecha;
		this.usuario = usuario;
		this.idVuelo = idVuelo;
		this.idInformePago = idInformePago;
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
