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
	
	public Vuelo(int numeroVuelo, Date salidaFecha, Date llegadaFecha, int asientosTotales, int asientosVacantes, Aeropuerto origen, Aeropuerto destino) {
		this.numeroVuelo = numeroVuelo;
		this.salidaFecha = salidaFecha;
		this.llegadaFecha = llegadaFecha;
		this.asientosTotales = asientosTotales;
		this.asientosVacantes= asientosVacantes;
		this.origen = origen;
		this.destino = destino;
	}
	
	public int getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	public Date getSalidaFecha() {
		return salidaFecha;
	}
	public void setSalidaFecha(Date salidaFecha) {
		this.salidaFecha = salidaFecha;
	}
	public Date getLlegadaFecha() {
		return llegadaFecha;
	}
	public void setLlegadaFecha(Date llegadaFecha) {
		this.llegadaFecha = llegadaFecha;
	}
	public int getAsientosTotales() {
		return asientosTotales;
	}
	public void setAsientosTotales(int asientosTotales) {
		this.asientosTotales = asientosTotales;
	}
	public int getAsientosVacantes() {
		return asientosVacantes;
	}
	public void setAsientosVacantes(int asientosVacantes) {
		this.asientosVacantes = asientosVacantes;
	}
	public Aeropuerto getOrigen() {
		return origen;
	}
	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}
	public Aeropuerto getDestino() {
		return destino;
	}
	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}
	
	
	

}
