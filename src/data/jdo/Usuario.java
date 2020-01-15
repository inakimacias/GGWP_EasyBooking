package data.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {
	
	@PrimaryKey
	private String email = null;
	private String password;
	private Aeropuerto predAirp = null;
	
	public Usuario() {
	}

	public Aeropuerto getPredAirp() {
		return predAirp;
	}

	public void setPredAirp(Aeropuerto predAirp) {
		this.predAirp = predAirp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean chekPassword(String password) {
		return this.password.equals(password);
	}
	
}
