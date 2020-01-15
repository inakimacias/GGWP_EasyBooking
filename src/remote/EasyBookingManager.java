package remote;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dto.DTOUsuario;
import data.dto.DTOVuelo;
import data.jdo.Usuario;

public class EasyBookingManager {

	private static EasyBookingManager instance;
	public Usuario state;
	
	private EasyBookingManager() throws RemoteException {
		super();		
	}
	
	public static EasyBookingManager getInstance() {
		if (instance == null) {
			try {
				instance = new EasyBookingManager();
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}
		return instance;
	}
	
	public boolean login(String email, String password) {		
		// this.state = LoginService.getInstance().login(email, password);
		
		return state != null;
	}
	
	public void buscarVuelo(String nombreOrigen, String nombreDestino) {
		
	}
	
	public void reservar(DTOUsuario usuario, DTOVuelo vuelo, ArrayList<String> nombres, String idCuenta, int coste) {
		
	}
	
}
