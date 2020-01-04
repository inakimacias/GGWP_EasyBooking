package dto;

import jdo.Aeropuerto;

public class DTOUsuario {

	private String email = null;
	private Aeropuerto predAirp = null;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Aeropuerto getPredAirp() {
		return predAirp;
	}
	public void setPredAirp(Aeropuerto predAirp) {
		this.predAirp = predAirp;
	}
}
