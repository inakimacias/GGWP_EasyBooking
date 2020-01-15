package server;

import java.rmi.Naming;

import remote.EasyBookingManager;
import remote.IEasyBookingManager;

public class Main {

	public static void main(String[] args) {	
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			IEasyBookingManager esayBookingManager = EasyBookingManager.getInstance();
			
			Naming.rebind(name, esayBookingManager);
			System.out.println(" * Auction server '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # Auction Server Exception: " + ex.getMessage());
		}
	}

}
