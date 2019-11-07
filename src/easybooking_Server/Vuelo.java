package easybooking_Server;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo {
	
	@PrimaryKey
	String idVuelo = null;
	
	@ForeignKey
	String idAerolinea = null;
	@ForeignKey
	String nomDestino = null;
	@ForeignKey
	String nomOrigen = null;
	
	public Vuelo(String idVuelo, String idAerolinea, String nomDestino, String nomOrigen) {
		this.idVuelo = idVuelo;
		this.idAerolinea = idAerolinea;
		this.nomDestino = nomDestino;
		this.nomOrigen = nomOrigen;
	}

	public String getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(String idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

	public String getNomDestino() {
		return nomDestino;
	}

	public void setNomDestino(String nomDestino) {
		this.nomDestino = nomDestino;
	}

	public String getNomOrigen() {
		return nomOrigen;
	}

	public void setNomOrigen(String nomOrigen) {
		this.nomOrigen = nomOrigen;
	}

	

}
