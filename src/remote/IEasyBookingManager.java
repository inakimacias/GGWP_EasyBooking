package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.DTOInformePago;
import dto.DTOReserva;
import dto.DTOUsuario;
import dto.DTOVuelo;

public interface IEasyBookingManager extends Remote {

	public String registrarse(String id, String password, String authType) throws RemoteException;
	public DTOUsuario login(String email, String password, String authType) throws RemoteException;
	public void reservar(DTOUsuario usuario, DTOVuelo vuelo, String nombres, String authType, String idCuenta) throws RemoteException;
	public ArrayList<DTOVuelo> buscarVuelo(String nombreOrigen, String nombreDestino) throws RemoteException;
	public ArrayList<DTOReserva> buscarReservas(DTOUsuario usuario) throws RemoteException;
	public DTOInformePago buscarInforme(DTOReserva reserva) throws RemoteException;
}
