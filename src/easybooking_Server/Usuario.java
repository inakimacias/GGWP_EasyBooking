package easybooking_Server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {
	
	@PrimaryKey
	String email = null;
	Aeropuerto predAirp = null;
	
	public Usuario(String email, Aeropuerto predAirp) {
		this.email = email;
		this.predAirp = predAirp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
