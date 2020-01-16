package gateways;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import jdo.Vuelo;

public class IberiaGw implements IAerolineaGw{
	String serverIP;
	int serverPort;
	private static IberiaGw instance = new IberiaGw();
	
	public static IberiaGw getInstance() {
		return instance;
	}
	
	public IberiaGw() {
		serverIP = "127.0.0.1";
		serverPort = 8003;
	}
	
	public ArrayList<Vuelo> buscarVuelo(String origen, String destino) {
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
		DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
		DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			String message = "bus;"+origen+";"+destino;
			out.writeUTF(message);
			System.out.println(" - TCPSocketClient: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + message + "'");
			
			String data = in.readUTF();			
			System.out.println(" - TCPSocketClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
			
			String misVuelos = data.replace(" ", "");
			ArrayList<String> vuelosMal = new ArrayList<String>();
			for(int i = 0; i<misVuelos.split(",").length; i++) {
				vuelosMal.add(misVuelos.split(";")[i]);
			}
			for(int j = 0; j<vuelosMal.size(); j++) {
				vuelos.add(new Vuelo(vuelosMal.get(j).split(";")[0], //id
						vuelosMal.get(j).split(";")[2], //FechaSalida
						vuelosMal.get(j).split(";")[3], //FechaLLegada
						Integer.parseInt(vuelosMal.get(j).split(";")[6]), //AsientosVacantes
						vuelosMal.get(j).split(";")[1], //Aerolinea
						vuelosMal.get(j).split(";")[5], //Destino
						vuelosMal.get(j).split(";")[4], //Origen
						Integer.parseInt(vuelosMal.get(j).split(";")[7]))); //Precio
			}
		} catch (UnknownHostException e) {
			System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
		}
		return vuelos;
	}
	
	public void reservarVuelo(String id, int plazas) {
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
		DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
		DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			String message = "res;"+id+";"+plazas;
			out.writeUTF(message);
			System.out.println(" - TCPSocketClient: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + message + "'");
			
			String data = in.readUTF();			
			System.out.println(" - TCPSocketClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
		} catch (UnknownHostException e) {
			System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
		}
	}
}
