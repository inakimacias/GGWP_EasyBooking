package service;

import java.util.ArrayList;

import assemblers.Assembler;
import dto.DTOVuelo;
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
	
	public ArrayList<DTOVuelo> buscarVuelo(String origen, String destino) {
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		ArrayList<DTOVuelo> DTOvuelos = new ArrayList<DTOVuelo>();
		vuelos.addAll(IberiaGw.getInstance().buscarVuelo(origen, destino));
		vuelos.addAll(RyannairGw.getInstance().buscarVuelo(origen, destino));
		vuelos.addAll(VuelingGw.getInstance().buscarVuelo(origen, destino));
		for(int i = 0; i < vuelos.size(); i++) {
			DTOvuelos.add(Assembler.getInstance().assemble(vuelos.get(i)));
		}
		return DTOvuelos;
	}

}
