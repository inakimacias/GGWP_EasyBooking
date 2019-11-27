package easybooking_Server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aerolinea {
	
	@PrimaryKey
	private String idAerolinea = null;
	
	public Aerolinea() {
	}

	public String getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(String idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

}
