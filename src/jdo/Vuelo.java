package jdo;

public class Vuelo {
	
	private String idVuelo = null;
	private String salidaFecha;
	private String llegadaFecha;
	private int asientosVacantes;
	private String aerolinea;
	private String aeropuertoDestino;
	private String aeropuertoOrigen;
	private int precio;

	
	
	public Vuelo(String idVuelo, String salidaFecha, String llegadaFecha, int asientosVacantes, String aerolinea,
			String aeropuertoDestino, String aeropuertoOrigen, int precio) {
		super();
		this.idVuelo = idVuelo;
		this.salidaFecha = salidaFecha;
		this.llegadaFecha = llegadaFecha;
		this.asientosVacantes = asientosVacantes;
		this.aerolinea = aerolinea;
		this.aeropuertoDestino = aeropuertoDestino;
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.precio = precio;
	}

	public Vuelo() {
	}

	public String getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}

	public int getAsientosVacantes() {
		return asientosVacantes;
	}

	public void setAsientosVacantes(int asientosVacantes) {
		this.asientosVacantes = asientosVacantes;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getSalidaFecha() {
		return salidaFecha;
	}

	public void setSalidaFecha(String salidaFecha) {
		this.salidaFecha = salidaFecha;
	}

	public String getLlegadaFecha() {
		return llegadaFecha;
	}

	public void setLlegadaFecha(String llegadaFecha) {
		this.llegadaFecha = llegadaFecha;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public String getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	public void setAeropuertoDestino(String aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}

	public String getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}

	public void setAeropuertoOrigen(String aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}

	@Override
	public String toString() {
		return "Vuelo [idVuelo=" + idVuelo + ", salidaFecha=" + salidaFecha + ", llegadaFecha=" + llegadaFecha
				+ ", asientosVacantes=" + asientosVacantes + ", aerolinea=" + aerolinea + ", aeropuertoDestino="
				+ aeropuertoDestino + ", aeropuertoOrigen=" + aeropuertoOrigen + ", precio=" + precio + "]";
	}
	
	
	
}
