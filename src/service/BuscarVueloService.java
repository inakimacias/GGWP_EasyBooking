package service;

import java.util.ArrayList;

import gateways.IberiaGw;
import gateways.RyannairGw;
import gateways.VuelingGw;
import jdo.Vuelo;

public class BuscarVueloService {
	
	private static BuscarVueloService instance;
	
	private BuscarVueloService() { }
	
	public static BuscarVueloService getInstance() {
		if (instance == null) {
			instance = new BuscarVueloService();
		}
	
		return instance;
	}
	
	public ArrayList<Vuelo> buscarVuelo(String origen, String destino) {
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		vuelos.addAll(IberiaGw.getInstance().buscarVuelo(origen, destino));
		vuelos.addAll(RyannairGw.getInstance().buscarVuelo(origen, destino));
		vuelos.addAll(VuelingGw.getInstance().buscarVuelo(origen, destino));
		return vuelos;
	}

}
