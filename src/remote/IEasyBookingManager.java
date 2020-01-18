package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.DTOUsuario;
import dto.DTOVuelo;

public interface IEasyBookingManager extends Remote {

	public void registrarse(String id, String password, String authType) throws RemoteException;
	public DTOUsuario login(String email, String password, String authType) throws RemoteException;
	public void reservar(DTOUsuario usuario, DTOVuelo vuelo, ArrayList<String> nombres, String authType, String idCuenta) throws RemoteException;
	public ArrayList<DTOVuelo> buscarVuelo(String nombreOrigen, String nombreDestino) throws RemoteException;

}
