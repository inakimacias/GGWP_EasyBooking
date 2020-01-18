package remote;

import java.rmi.Naming;
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
	
	private EasyBookingManager() throws RemoteException {
		super();		
	}
	
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {		
			IEasyBookingManager objServer = new EasyBookingManager();
			Naming.rebind(name, objServer);
			System.out.println("* Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
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
