package data.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class EntidadBancaria {

	@PrimaryKey
	private String idEntBancaria = "";
	private long numTarjeta = 0;
	
	public EntidadBancaria() {
	}

	public String getIdEntBancaria() {
		return idEntBancaria;
	}

	public void setIdEntBancaria(String idEntBancaria) {
		this.idEntBancaria = idEntBancaria;
	}

	public long getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(long numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	
}
