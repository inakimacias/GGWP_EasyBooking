package service;

import gateways.*;

public class Factory {
	
	private static Factory instance = new Factory();
	
	public static Factory getInstance() {
		return instance;
	}
	
	public ILoginGw createLoginGw(String type) {
		ILoginGw gw = null;
		switch(type) {
		case "google":
			gw = GoogleGw.getInstance();
			break;
		case "facebook":
			gw = FacebookGw.getInstance();
			break;
		default:
			System.out.println("Error creando loginGw");
			break;
		}
		return gw;
	}
	
	public IAerolineaGw createAerolineaGw(String type) {
		IAerolineaGw gw = null;
		switch(type) {
		case "iberia":
			gw = IberiaGw.getInstance();
		case "ryannair":
			gw = RyannairGw.getInstance();
		case "vueling":
			gw = VuelingGw.getInstance();
		default:
			System.out.println("Error creando loginGw");
		}
		return gw;
	}
	
	public IPagoGw createPagoGw(String type) {
		IPagoGw gw = null;
		switch(type) {
		case "banco":
			gw = EntidadGw.getInstance();
		case "paypal":
			gw = PaypalGw.getInstance();
		default:
			System.out.println("Error creando loginGw");
		}
		return gw;
	}
}
