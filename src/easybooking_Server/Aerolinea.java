package easybooking_Server;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Aerolinea {
	
	String idAerolinea = null;
	String nombreAerolinea = null;
	
	public Aerolinea(String idAerolinea, String nombreAerolinea) {
		idAerolinea = this.idAerolinea;
		nombreAerolinea = this.nombreAerolinea;
	}

}
