package easybooking_Server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class MetodoPago {

	@PrimaryKey
	String idMetPago = "";
	
	public MetodoPago(String idMetPago) {
		this.idMetPago = idMetPago;
	}

	public String getIdMetPago() {
		return idMetPago;
	}

	public void setIdMetPago(String idMetPago) {
		this.idMetPago = idMetPago;
	}

}
