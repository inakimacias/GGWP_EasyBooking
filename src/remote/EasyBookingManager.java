package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dto.DTOUsuario;
import dto.DTOVuelo;
import service.BuscarVueloService;
import service.LoginService;
import service.RegisterService;
import service.ReservaService;

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
	
	public boolean registrarse(String id, String password, String authType) throws RemoteException {
		return RegisterService.getInstance().registro(id, password, authType);
	}

	public DTOUsuario login(String email, String password, String authType) throws RemoteException {
		return LoginService.getInstance().login(email, password, authType);
	}

	public ArrayList<DTOVuelo> buscarVuelo(String nombreOrigen, String nombreDestino) throws RemoteException {
		return BuscarVueloService.getInstance().buscarVuelo(nombreOrigen, nombreDestino);
	}
	
	public void reservar(DTOUsuario usuario, DTOVuelo vuelo, String nombres, String authType, String idCuenta) throws RemoteException {
		ReservaService.getInstance().reservar(usuario, vuelo, nombres, authType, idCuenta);
	}
}
