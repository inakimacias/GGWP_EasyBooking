package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dto.DTOUsuario;
import dto.DTOVuelo;

public class EasyBookingManager extends UnicastRemoteObject implements IEasyBookingManager {

	private static final long serialVersionUID = 1L;
	private static EasyBookingManager instance;
	
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
	public void registrarse(String id, String password, String authType) throws RemoteException {
		
	}

	public boolean login(String email, String password, String authType) throws RemoteException {
		
		return false;
	}

	public ArrayList<DTOVuelo> buscarVuelo(String nombreOrigen, String nombreDestino) throws RemoteException {
	
		return null;
	}
	public void reservar(DTOUsuario usuario, DTOVuelo vuelo, ArrayList<String> nombres, String authType, String idCuenta)
		throws RemoteException {
	
	}
}
