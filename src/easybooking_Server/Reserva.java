package easybooking_Server;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {	

	@PrimaryKey
	String idReserva = null;
	int numPasajeros = 0;
	Date fecha = null;
	double hora = 0;

	public Reserva(String idReserva, int numPasajeros, Date fecha, double hora) {
		this.idReserva = idReserva;
		this.numPasajeros = numPasajeros;
		this.fecha = fecha;
		this.hora = hora;
	}
}
