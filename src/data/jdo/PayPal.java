package data.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class PayPal {

	@PrimaryKey
	private String idPaypal = "";
	
	public PayPal() {
	}

	public String getIdPaypal() {
		return idPaypal;
	}

	public void setIdPaypal(String idPaypal) {
		this.idPaypal = idPaypal;
	}
	
	
}
