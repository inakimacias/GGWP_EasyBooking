package data.utilities;

import data.dto.DTOAeropuerto;
import data.jdo.Aeropuerto;

public class AeropuertoAssembler {

	private static AeropuertoAssembler instance;

	private AeropuertoAssembler() { }
	
	public static AeropuertoAssembler getInstance() {
		if (instance == null) {
			instance = new AeropuertoAssembler();
		}

		return instance;
	}

	public DTOAeropuerto entityToDTO(Aeropuerto aeropuerto) {
		DTOAeropuerto dto = new DTOAeropuerto();
		
		dto.setNombreAeropuerto(aeropuerto.getNombreAeropuerto());
		
		return dto;
	}
}
