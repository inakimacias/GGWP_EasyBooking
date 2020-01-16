package jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class InformePago {
	
	@PrimaryKey
	private String idInformePago;
	private double coste;
	private String fecha;
	private String MetodoPago;
	private String idCuenta;
	
	public InformePago() {
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public String getIdInformePago() {
		return idInformePago;
	}

	public void setIdInformePago(String idInformePago) {
		this.idInformePago = idInformePago;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMetodoPago() {
		return MetodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		MetodoPago = metodoPago;
	}

	public String getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	
	
}
