package assemblers;

import dto.DTOVuelo;
import jdo.Vuelo;

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
		
		dto.setAsientosVacantes(vuelo.getAsientosVacantes());
		dto.setIdVuelo(vuelo.getIdVuelo());
		
		return dto;
	}
}
