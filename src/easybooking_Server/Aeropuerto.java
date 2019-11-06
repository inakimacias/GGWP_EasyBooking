package easybooking_Server;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Aeropuerto {
	
	String nombreAeropuerto = null;
	
	public Aeropuerto(String nombreAeropuerto) {
		nombreAeropuerto = this.nombreAeropuerto;
	}

	public String getNombreAeropuerto() {
		return nombreAeropuerto;
	}

	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}

}
