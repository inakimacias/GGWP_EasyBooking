package easybooking_Server;

public class EntidadBancaria {

	String idEntBancaria = "";
	long numTarjeta = 0;
	
	public EntidadBancaria(String idEntBancaria, long numTarjeta) {
		this.idEntBancaria = idEntBancaria;
		this.numTarjeta = numTarjeta;
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
