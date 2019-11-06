package easybooking_Server;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo {
	
	@PrimaryKey
	int numeroVuelo = 0;
	
	Date salidaFecha = null;
	Date llegadaFecha = null;
	int asientosTotales = 0;
	int asientosVacantes = 0;
	Aeropuerto origen = new Aeropuerto(null);
	Aeropuerto destino = new Aeropuerto(null);
	
	
	

}
