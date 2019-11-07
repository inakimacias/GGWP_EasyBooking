package easybooking_Server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class PayPal {

	@PrimaryKey
	String idPaypal = "";
	
	public PayPal(String idPaypal) {
		this.idPaypal = idPaypal;
	}

	public String getIdPaypal() {
		return idPaypal;
	}

	public void setIdPaypal(String idPaypal) {
		this.idPaypal = idPaypal;
	}
	
	
}
