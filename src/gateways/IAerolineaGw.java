package gateways;

import java.util.ArrayList;

import jdo.Vuelo;

public interface IAerolineaGw {
	public ArrayList<Vuelo> buscarVuelo(String origen, String destino);
	public void reservarVuelo(String id, int plazas);
}
