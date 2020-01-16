package gateways;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PaypalGw implements IPagoGw{
	String serverIP;
	int serverPort;
	private static PaypalGw instance = new PaypalGw();
	
	public static PaypalGw getInstance() {
		return instance;
	}
	
	public PaypalGw() {
		serverIP = "127.0.0.1";
		serverPort = 8006;
	}
	
	public void pagar(String id, double cantidad) {
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
		DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
		DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			String message = "pay;"+id+";"+cantidad;
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
