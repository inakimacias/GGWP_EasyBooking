package easybooking_Server;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo {
	
	@PrimaryKey
	int numeroVuelo = 0;
	
	@ForeignKey
	String nomAerolinea = null;
	@ForeignKey
	String nomDestino = null;
	@ForeignKey
	String nomOrigen = null;

	public Vuelo(int numeroVuelo, String nomAerolinea, String nomDestino, String nomOrigen) {
		super();
		this.numeroVuelo = numeroVuelo;
		this.nomAerolinea = nomAerolinea;
		this.nomDestino = nomDestino;
		this.nomOrigen = nomOrigen;
	}
	
	public int getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public String getNomAerolinea() {
		return nomAerolinea;
	}

	public void setNomAerolinea(String nomAerolinea) {
		this.nomAerolinea = nomAerolinea;
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
