package easybooking_Server;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {	

	@PrimaryKey
	String idReserva = null;
	int numPasajeros = 0;
	String[] nombrePasajeros = null;
	Date fecha = null;

	public Reserva(String idReserva, int numPasajeros, String[] nombrePasajeros, Date fecha) {
		this.idReserva = idReserva;
		this.numPasajeros = numPasajeros;
		this.nombrePasajeros = nombrePasajeros;
		this.fecha = fecha;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
}
