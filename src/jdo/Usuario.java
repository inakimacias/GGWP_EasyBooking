package jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {
	
	@PrimaryKey
	private String email;
	private String predAirp;
	
	public Usuario() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPredAirp() {
		return predAirp;
	}

	public void setPredAirp(String predAirp) {
		this.predAirp = predAirp;
	}
	
	
	
}
