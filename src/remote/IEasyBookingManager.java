package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dto.DTOUsuario;
import data.dto.DTOVuelo;



public interface IEasyBookingManager extends Remote {

	public boolean login(String email, String password) throws RemoteException;
	public void reservar(DTOUsuario usuario, DTOVuelo vuelo, ArrayList<String> nombres, String idCuenta, int coste) throws RemoteException;
	public void buscarVuelo(String nombreOrigen, String nombreDestino) throws RemoteException;

}
