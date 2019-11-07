package easybooking_Server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aerolinea {
	
	@PrimaryKey
	String idAerolinea = null;
	
	public Aerolinea(String idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

	public String getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(String idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

}
