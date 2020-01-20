package dto;

import java.io.Serializable;

public class DTOInformePago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idInformePago;
	private double coste;
	private String fecha;
	private String MetodoPago;
	private String idCuenta;
	
	public String getIdInformePago() {
		return idInformePago;
	}
	public void setIdInformePago(String idInformePago) {
		this.idInformePago = idInformePago;
	}
	public double getCoste() {
		return coste;
	}
	public void setCoste(double coste) {
		this.coste = coste;
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
	
	@Override
	public String toString() {
		return "DTOInformePago [idInformePago=" + idInformePago + ", coste=" + coste + ", fecha=" + fecha
				+ ", MetodoPago=" + MetodoPago + ", idCuenta=" + idCuenta + "]";
	}
	
	
}
