package easybooking_Server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aerolinea {
	
	@PrimaryKey
	String idAerolinea = null;
	String nombreAerolinea = null;
	
	public Aerolinea(String idAerolinea, String nombreAerolinea) {
		idAerolinea = this.idAerolinea;
		nombreAerolinea = this.nombreAerolinea;
	}

	public String getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(String idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

	public String getNombreAerolinea() {
		return nombreAerolinea;
	}

	public void setNombreAerolinea(String nombreAerolinea) {
		this.nombreAerolinea = nombreAerolinea;
	}

}
