package data.utilities;

import java.util.ArrayList;
import java.util.List;

import data.dto.DTOAerolinea;
import data.jdo.Aerolinea;


public class AerolineaAssembler {

	private static AerolineaAssembler instance;
	
	private AerolineaAssembler() { }
	
	public static AerolineaAssembler getInstance() {
		if (instance == null) {
			instance = new AerolineaAssembler();
		}
		return instance;
	}
	
	public DTOAerolinea entityToDTO(Aerolinea aerolinea) {
		DTOAerolinea dto = new DTOAerolinea();
		
		dto.setIdAerolinea(aerolinea.getIdAerolinea());
		dto.setNombreAerolinea(aerolinea.getNombreAerolinea());
			
		return dto;
	}
	
	public List<DTOAerolinea> entityToDTO(List<Aerolinea> aerolineas) {		
		List<DTOAerolinea> dtos = new ArrayList<>();
		
		for (Aerolinea aerolinea : aerolineas) {
			dtos.add(this.entityToDTO(aerolinea));
		}
		return dtos;
	}
}
