package easybooking_server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class MetodoPago {

	@PrimaryKey
	private String idMetPago = "";
	
	public MetodoPago() {
	}

	public String getIdMetPago() {
		return idMetPago;
	}

	public void setIdMetPago(String idMetPago) {
		this.idMetPago = idMetPago;
	}

}
