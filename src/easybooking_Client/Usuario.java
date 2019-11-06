package easybooking_Client;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {
	
	@PrimaryKey
	String email = null;
	
	public Usuario(String email) {
		email = this.email;
	}
	
}
