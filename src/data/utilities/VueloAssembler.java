package data.utilities;

import data.dto.DTOVuelo;
import data.jdo.Vuelo;

public class VueloAssembler {

	private static VueloAssembler instance;

	private VueloAssembler() { }
	
	public static VueloAssembler getInstance() {
		if (instance == null) {
			instance = new VueloAssembler();
		}

		return instance;
	}

	public DTOVuelo entityToDTO(Vuelo vuelo) {
		DTOVuelo dto = new DTOVuelo();
		
		dto.setAsientosTotales(vuelo.getAsientosTotales());
		dto.setAsientosVacantes(vuelo.getAsientosVacantes());
		dto.setIdVuelo(vuelo.getIdVuelo());
		dto.setLlegadaFecha(vuelo.getLlegadaFecha());
		dto.setSalidaFecha(vuelo.getSalidaFecha());
		
		return dto;
	}
}
