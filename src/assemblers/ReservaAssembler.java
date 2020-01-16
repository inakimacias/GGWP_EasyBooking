package assemblers;

import dto.DTOReserva;
import jdo.Reserva;

public class ReservaAssembler {

	private static ReservaAssembler instance;

	private ReservaAssembler() { }
	
	public static ReservaAssembler getInstance() {
		if (instance == null) {
			instance = new ReservaAssembler();
		}

		return instance;
	}

	public DTOReserva entityToDTO(Reserva reserva) {
		DTOReserva dto = new DTOReserva();
		
		dto.setIdReserva(reserva.getIdReserva());
		dto.setNumPasajeros(reserva.getNumPasajeros());
		dto.setFecha(reserva.getFecha());
		
		return dto;
	}
}
