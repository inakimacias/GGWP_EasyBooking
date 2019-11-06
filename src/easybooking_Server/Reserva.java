package easybooking_Server;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {	

	@PrimaryKey
	String idReserva = null;
	int numPasajeros = 0;
	Vuelo vuelo = null;
	Date fecha = null;
	double hora = 0;

	public Reserva(String idReserva, int numPasajeros, Date fecha, double hora) {
		this.idReserva = idReserva;
		this.numPasajeros = numPasajeros;
		this.fecha = fecha;
		this.hora = hora;
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

	public double getHora() {
		return hora;
	}

	public void setHora(double hora) {
		this.hora = hora;
	}
	
	
}
